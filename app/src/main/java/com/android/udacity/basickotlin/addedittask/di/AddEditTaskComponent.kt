package com.android.udacity.basickotlin.addedittask.di

import com.android.udacity.basickotlin.addedittask.AddEditTaskActivity
import com.android.udacity.basickotlin.base.BaseModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Mayokun on 7/31/2017.
 */
@Singleton
@Component(modules = arrayOf(AddEditTaskModule::class,
                            BaseModule::class))
interface AddEditTaskComponent {

    fun inject(addEditTaskActivity: AddEditTaskActivity)

}