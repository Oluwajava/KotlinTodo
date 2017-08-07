package com.android.udacity.basickotlin.task.adapter

import android.view.View
import android.widget.TextView
import com.android.udacity.basickotlin.R
import com.android.udacity.basickotlin.abstracts.AbstractViewHolder
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.listeners.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.adapter_todo.*
import kotlinx.android.synthetic.main.adapter_todo.view.*
import org.w3c.dom.Text

/**
 * Created by Mayokun on 8/5/2017.
 */
class TaskViewHolder(var view: View, var recyclerViewItemClickListener: RecyclerViewItemClickListener<Todo>): AbstractViewHolder<Todo>(view, recyclerViewItemClickListener) {

    lateinit var todo: Todo

    init {
        view.setOnClickListener {
            recyclerViewItemClickListener.onItemClick(todo, adapterPosition)
        }

    }

    override fun getItem(): Todo {
        return todo
    }

    override fun bindView(t: Todo) {
        this.todo = t
        view.titleTextView.text = t.todo
        view.description.text = t.description

        view.removeTask.setOnClickListener {
            recyclerViewItemClickListener.onEditItemClick(t, adapterPosition)
        }
    }


}