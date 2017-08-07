package com.android.udacity.basickotlin.task.di

import com.android.udacity.basickotlin.base.BaseModule
import com.android.udacity.basickotlin.task.TaskFragment
import dagger.Component

/**
 * Created by Mayokun on 8/5/2017.
 */
@Component(modules = arrayOf(TaskModule::class,
                                BaseModule::class))
interface TaskComponent {

    fun inject(taskFragment: TaskFragment)

}