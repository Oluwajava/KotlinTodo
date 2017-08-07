package com.android.udacity.basickotlin.task

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.udacity.basickotlin.R
import com.android.udacity.basickotlin.addedittask.AddEditTaskActivity
import com.android.udacity.basickotlin.base.BaseModule
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.listeners.LoadCallback
import com.android.udacity.basickotlin.listeners.RecyclerViewItemClickListener
import com.android.udacity.basickotlin.task.adapter.TaskAdapter
import com.android.udacity.basickotlin.task.di.DaggerTaskComponent
import com.android.udacity.basickotlin.task.di.TaskModule
import com.android.udacity.basickotlin.utils.Constants
import kotlinx.android.synthetic.main.fragment_task.view.*
import org.parceler.Parcels
import javax.inject.Inject

/**
 * Created by Mayokun on 8/5/2017.
 */
class TaskFragment : Fragment(), RecyclerViewItemClickListener<Todo>, TaskContract.View, LoadCallback<Todo> {

    @Inject
    lateinit var taskPresenter: TaskPresenter

    lateinit var todoAdapter: TaskAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater!!.inflate(R.layout.fragment_task, container, false)

        DaggerTaskComponent.builder()
                .baseModule(BaseModule(activity))
                .taskModule(TaskModule(this))
                .build()
                .inject(this)

        var list: ArrayList<Todo> = arrayListOf(Todo("test", "test"), Todo("test", "test"), Todo("test", "test"))
        todoAdapter = TaskAdapter(R.layout.adapter_todo, list, this)

        view.taskRecyclerView.layoutManager = LinearLayoutManager(activity)
        view.taskRecyclerView.adapter = todoAdapter
        taskPresenter.loadCallBack = this
        taskPresenter.retrieveTodoList()

        return view
    }

    override fun onItemClick(t: Todo, position: Int) {

    }

    override fun onItemLoaded(list: List<Todo>) {
        todoAdapter.list = list
        todoAdapter.notifyDataSetChanged()
    }

    override fun onItemDeleteClick(t: Todo, position: Int) {
        taskPresenter.removeTodo(t)
    }

    override fun onEditItemClick(t: Todo, position: Int) {
        var intent: Intent = Intent(activity, AddEditTaskActivity::class.java)
        intent.putExtra(Constants.TODO, Parcels.wrap(t))
        startActivity(intent)
    }

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)

    }

}