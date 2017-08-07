package com.android.udacity.basickotlin.addedittask

import com.android.udacity.basickotlin.base.BasePresenter
import com.android.udacity.basickotlin.base.BaseView
import com.android.udacity.basickotlin.domain.entity.Todo

/**
 * Created by Mayokun on 7/31/2017.
 */
interface AddEditTaskContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {
        fun addTask(todo: Todo)
        fun updateTask(todo: Todo)
    }
}