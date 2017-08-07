package com.android.udacity.basickotlin.domain

/**
 * Created by Mayokun on 8/3/2017.
 */
interface RepositoryData<T> {

    fun create(t: T)

    fun remove(id: Int)

    fun update(t: T)

    fun query(): List<T>

    fun query(specification: Specification): List<T>

}