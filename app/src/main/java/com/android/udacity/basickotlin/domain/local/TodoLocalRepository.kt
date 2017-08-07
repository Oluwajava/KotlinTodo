package com.android.udacity.basickotlin.domain.local

import android.content.Context
import com.android.udacity.basickotlin.domain.RepositoryData
import com.android.udacity.basickotlin.domain.Specification
import com.android.udacity.basickotlin.domain.entity.Todo
import io.realm.Realm

/**
 * Created by Mayokun on 8/3/2017.
 */
class TodoLocalRepository : RepositoryData<Todo> {

    var realm: Realm

    constructor(context: Context) {
        Realm.init(context)
        realm = Realm.getDefaultInstance()
    }

    override fun remove(id: Int) {
        val category = realm.where(Todo::class.java).equalTo("id", id).findFirst()
        realm.executeTransaction { realm -> category.deleteFromRealm() }
    }

    override fun update(todo: Todo) {
        val results = realm.where(Todo::class.java).equalTo("id", todo.id).findFirst()
        realm.executeTransaction { realm ->
            results.todo = todo.todo
            results.description = todo.description
        }
    }

    override fun query(): List<Todo> {
        return realm.where(Todo::class.java).findAll()
    }

    override fun create(todo: Todo) {
        realm.executeTransaction { realm ->
            val index = realm.where(Todo::class.java).max("id")
            val nextId = if (index == null) 1 else index!!.toInt() + 1
            todo.id = nextId
            val realmTodo = realm.copyToRealm(todo)
        }
    }

    override fun query(specification: Specification): List<Todo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}