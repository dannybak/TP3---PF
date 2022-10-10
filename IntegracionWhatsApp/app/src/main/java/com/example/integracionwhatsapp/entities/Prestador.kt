package com.example.integracionwhatsapp.entities

class Prestador (id : Int, name : String, lastname : String, age : Int, tel : String, rubro : String, img : String){

    var id : Int
    var name : String
    var lastname : String
    var age : Int
    var tel : String
    var rubro : String
    var img : String

    init {
        this.id = id
        this.name = name
        this.lastname = lastname
        this.age = age
        this.tel = tel
        this.rubro = rubro
        this.img = img
    }
}