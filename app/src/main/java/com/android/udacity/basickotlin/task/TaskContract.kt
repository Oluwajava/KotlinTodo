package com.android.udacity.basickotlin.task

import com.android.udacity.basickotlin.base.BasePresenter
import com.android.udacity.basickotlin.base.BaseView
import com.android.udacity.basickotlin.domain.entity.Todo

/**
 * Created by Mayokun on 8/5/2017.
 */
interface TaskContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter: BasePresenter {
        fun retrieveTodoList()
        fun removeTodo(t: Todo)
    }
}