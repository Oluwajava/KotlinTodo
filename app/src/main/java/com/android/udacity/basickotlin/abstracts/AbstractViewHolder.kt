package com.android.udacity.basickotlin.abstracts

import android.support.v7.widget.RecyclerView
import android.view.View
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.listeners.RecyclerViewItemClickListener

/**
 * Created by Mayokun on 8/5/2017.
 */
abstract class AbstractViewHolder<T>(itemView: View?, recyclerViewItemClickListener: RecyclerViewItemClickListener<T>) : RecyclerView.ViewHolder(itemView) {
    fun AbstractViewHolder(itemView: View, reclerViewItemClickListener: RecyclerViewItemClickListener<T>){
        itemView.setOnClickListener { view -> reclerViewItemClickListener.onItemClick(getItem(), adapterPosition) }
    }

    fun AbstractViewHolder(itemView: View) {
    }

    abstract fun bindView(t: T)

    protected abstract fun getItem(): T
}

