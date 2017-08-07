package com.android.udacity.basickotlin.addedittask

import com.android.udacity.basickotlin.domain.TodoRepository
import com.android.udacity.basickotlin.domain.entity.Todo
import com.android.udacity.basickotlin.domain.local.TodoLocalRepository
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

/**
 * Created by Mayokun on 7/31/2017.
 */
class AddEditTaskPresenter : AddEditTaskContract.Presenter, AnkoLogger {

    var view: AddEditTaskContract.View
    var repository: TodoRepository

    @Inject constructor(view: AddEditTaskContract.View, repository: TodoRepository) {
        this.view = view;
        this.repository = repository
    }

    override fun start() {

        var todo: List<Todo> = repository.query()
        info { "Testing" }
    }

    override fun addTask(todo: Todo) {
        repository.create(todo)
    }

    override fun updateTask(todo: Todo) {
        repository.update(todo)
    }

}