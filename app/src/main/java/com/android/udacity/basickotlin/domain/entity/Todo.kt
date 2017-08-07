package com.android.udacity.basickotlin.domain.entity

import android.os.Parcelable
import io.realm.RealmObject
import org.parceler.Parcel
import org.parceler.ParcelConstructor

/**
 * Created by Mayokun on 8/3/2017.
 */
open class Todo() : RealmObject(), Parcelable {
    var todo: String? = null
    var description: String? = null
    var id: Int? = null

    constructor(parcel: android.os.Parcel) : this() {
        todo = parcel.readString()
        description = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    constructor(todo: String?, description: String?) : this() {
        this.todo = todo
        this.description = description
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(todo)
        parcel.writeString(description)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: android.os.Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }


}