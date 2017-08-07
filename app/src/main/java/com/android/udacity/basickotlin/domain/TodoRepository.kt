package com.android.udacity.basickotlin.domain

import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.domain.local.TodoLocalRepository
import org.parceler.Repository
import javax.inject.Inject

/**
 * Created by Mayokun on 8/3/2017.
 */
class TodoRepository @Inject constructor(var todoLocalRepository: TodoLocalRepository): RepositoryData<Todo> {

    override fun query(specification: Specification): List<Todo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(): List<Todo> {
        return todoLocalRepository.query()
    }

    override fun update(todo: Todo) {
        todoLocalRepository.update(todo)
    }

    override fun create(t: Todo) {
        todoLocalRepository.create(t)
    }

    override fun remove(id: Int) {
        todoLocalRepository.remove(id)
    }



}