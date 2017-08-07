package com.android.udacity.basickotlin.addedittask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.udacity.basickotlin.R
import com.android.udacity.basickotlin.addedittask.di.AddEditTaskModule
import com.android.udacity.basickotlin.addedittask.di.DaggerAddEditTaskComponent
import com.android.udacity.basickotlin.base.BaseModule
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.utils.Constants
import kotlinx.android.synthetic.main.activity_addedittask.*
import org.parceler.Parcels
import javax.inject.Inject

/**
 * Created by Mayokun on 7/31/2017.
 */
class AddEditTaskActivity : AppCompatActivity(), AddEditTaskContract.View {

    @Inject
    lateinit var presenter: AddEditTaskPresenter

    lateinit var todo: Todo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addedittask)

        DaggerAddEditTaskComponent.builder()
                .addEditTaskModule(AddEditTaskModule(this))
                .baseModule(BaseModule(this))
                .build()
                .inject(this)

        if(intent.hasExtra(Constants.TODO)) {
            todo = Parcels.unwrap(intent.getParcelableExtra(Constants.TODO))
            titleEditText.setText(todo.todo)
            notesEditText.setText(todo.description)
        }

        presenter.start()

        saveTaskButton.setOnClickListener {
            var t: Todo = Todo(todo = titleEditText.text.toString(), description = notesEditText.text.toString())
            if(intent.hasExtra(Constants.TODO)) {
                t.id = todo.id
                presenter.updateTask(t)
            }else{
                presenter.addTask(t)
            }
            finish()
        }
    }
}