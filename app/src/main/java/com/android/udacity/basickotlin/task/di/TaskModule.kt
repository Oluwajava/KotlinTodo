package com.android.udacity.basickotlin.task.di

import com.android.udacity.basickotlin.task.TaskContract
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by Mayokun on 8/5/2017.
 */
@Module
class TaskModule @Inject constructor(var view: TaskContract.View) {

    @Provides
    fun provideView(): TaskContract.View {
        return view
    }

}