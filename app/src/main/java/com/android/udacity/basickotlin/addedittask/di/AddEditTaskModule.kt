package com.android.udacity.basickotlin.addedittask.di

import com.android.udacity.basickotlin.addedittask.AddEditTaskContract
import dagger.Module
import dagger.Provides

/**
 * Created by Mayokun on 7/31/2017.
 */
@Module
class AddEditTaskModule(val addEditTaskView: AddEditTaskContract.View) {

    @Provides
    fun providesAddEditTaskView(): AddEditTaskContract.View {
        return addEditTaskView
    }
}