package com.example.scalonetaapp.database

import androidx.room.*
import com.example.scalonetaapp.entities.User

@Dao

public interface userDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllUsers(): MutableList<User?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?)

    @Update
    fun updateUser(user: User?)

    @Delete
    fun delete(user: User?)

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadUserById(id: Int): User?

}