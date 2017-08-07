package com.android.udacity.basickotlin.abstracts

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Mayokun on 8/5/2017.
 */
abstract class AbstractRecyclerView<T, V:AbstractViewHolder<T>>(var itemResourceId: Int, var list: List<T>): RecyclerView.Adapter<V>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): V {
        var view: View = LayoutInflater.from(parent!!.context)
                .inflate(itemResourceId, parent, false)

        var v: V = this.initializezViewHolder(view)

        return v
    }

    abstract fun initializezViewHolder(view: View): V

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.bindView(list.get(position))
    }

    override fun getItemCount(): Int {
        if (list != null)
            return list.size
        else
            return 0
    }

    fun setItems(items: List<T>) {
        this.list = items
    }
}

