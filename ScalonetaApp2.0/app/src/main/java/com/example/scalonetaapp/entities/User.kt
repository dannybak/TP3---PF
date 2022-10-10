package com.example.scalonetaapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")

class User(id : Int, username : String, password : String, img : String)
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "username")
    var username : String

    @ColumnInfo(name = "password")
    var password : String

    @ColumnInfo(name = "img")
    var img : String

    init {
        this.id = id
        this.username = username
        this.password = password
        this.img = img
    }
}