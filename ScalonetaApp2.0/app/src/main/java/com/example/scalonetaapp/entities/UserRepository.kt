package com.example.scalonetaapp.entities

class UserRepository {

    private var userList : MutableList<User> = mutableListOf()

    init{
        userList.add(User(1,
            "dannybak",
            "12345",
            "../res/drawable/userdefault.png"
        ))

        userList.add(User(2,
            "jaimito99",
            "23456",
            "../res/drawable/userdefault.png"
        ))

        userList.add(User(3,
            "julian1231",
            "34567",
            "../res/drawable/userdefault.png"
        ))

        userList.add(User(4,
            "jorgeGrandote",
            "45678",
            "../res/drawable/userdefault.png"
        ))
    }

    fun getUsers () : MutableList<User>{
        return userList
    }

}