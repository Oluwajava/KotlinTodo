package com.android.udacity.basickotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.udacity.basickotlin.addedittask.AddEditTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTask.setOnClickListener {
            var addTaskActivityIntent: Intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(addTaskActivityIntent)
        }
    }
}
