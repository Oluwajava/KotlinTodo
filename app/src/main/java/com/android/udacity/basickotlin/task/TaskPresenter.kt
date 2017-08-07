package com.android.udacity.basickotlin.task

import com.android.udacity.basickotlin.domain.TodoRepository
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.listeners.LoadCallback
import javax.inject.Inject

/**
 * Created by Mayokun on 8/5/2017.
 */
class TaskPresenter @Inject constructor(private val view: TaskContract.View,private val repository: TodoRepository): TaskContract.Presenter{

    lateinit var loadCallBack: LoadCallback<Todo>

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveTodoList() {
        var listOfTodos: List<Todo> = repository.query()
        loadCallBack.onItemLoaded(listOfTodos)
    }

    override fun removeTodo(t: Todo) {
        repository.remove(t.id!!)
        retrieveTodoList()
    }


}