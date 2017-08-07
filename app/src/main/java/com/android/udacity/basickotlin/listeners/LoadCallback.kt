package com.android.udacity.basickotlin.listeners

/**
 * Created by Mayokun on 8/5/2017.
 */
interface LoadCallback<T> {

    fun onItemLoaded(list: List<T>)

}