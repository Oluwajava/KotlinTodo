package com.android.udacity.basickotlin.task.adapter

import android.view.View
import com.android.udacity.basickotlin.abstracts.AbstractRecyclerView
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.listeners.RecyclerViewItemClickListener

/**
 * Created by Mayokun on 8/5/2017.
 */
class TaskAdapter(itemResourceId: Int,list: List<Todo>, var recyclerViewItemClickListener: RecyclerViewItemClickListener<Todo>) : AbstractRecyclerView<Todo, TaskViewHolder>(itemResourceId, list) {

    override fun initializezViewHolder(view: View): TaskViewHolder {
        return TaskViewHolder(view, recyclerViewItemClickListener)
    }


}