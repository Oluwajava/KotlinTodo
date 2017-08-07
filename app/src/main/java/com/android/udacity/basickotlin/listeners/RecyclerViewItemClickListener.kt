package com.android.udacity.basickotlin.listeners

/**
 * Created by Mayokun on 8/5/2017.
 */
interface RecyclerViewItemClickListener<T> {
    fun onItemClick(t: T, position: Int)
    fun onEditItemClick(t: T, position: Int)
    fun onItemDeleteClick(t: T, position: Int)
}
