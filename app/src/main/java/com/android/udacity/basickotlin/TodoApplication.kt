package com.android.udacity.basickotlin

import android.app.Application
import com.android.udacity.basickotlin.addedittask.di.AddEditTaskComponent

/**
 * Created by Mayokun on 7/31/2017.
 */
class TodoApplication: Application() {

    companion object {
        lateinit var addEditTaskComponent: AddEditTaskComponent
    }


}

