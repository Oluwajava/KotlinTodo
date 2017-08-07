package com.android.udacity.basickotlin.base

import android.content.Context
import com.android.udacity.basickotlin.domain.TodoRepository
import com.android.udacity.basickotlin.domain.local.TodoLocalRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Mayokun on 8/3/2017.
 */
@Module
class BaseModule(val context: Context) {

    @Provides
    fun providesTodoLocalRepository(): TodoLocalRepository {
        return TodoLocalRepository(context)
    }

    @Provides
    fun providesTodoRepository(): TodoRepository {
        return TodoRepository(TodoLocalRepository(context))
    }

}