package com.example.scalonetaapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")

class Player(id : Int, fullname : String, position : String, birthPlace: String, age : Int, number : Int, img : String)
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "fullname")
    var fullname : String

    @ColumnInfo(name = "position")
    var position : String

    @ColumnInfo(name = "birthplace")
    var birthPlace : String

    @ColumnInfo(name = "number")
    var number : Int

    @ColumnInfo(name = "age")
    var age : Int

    @ColumnInfo(name = "img")
    var img : String

    init {
        this.id = id
        this.fullname = fullname
        this.position = position
        this.birthPlace = birthPlace
        this.number = number
        this.age = age
        this.img = img
    }
}