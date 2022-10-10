package com.example.scalonetaapp.database

import androidx.room.*
import com.example.scalonetaapp.entities.Player

@Dao

public interface playerDao {

    @Query("SELECT * FROM players ORDER BY id")
    fun loadAllPlayers(): MutableList<Player?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(player: Player?)

    @Update
    fun updatePlayer(player: Player?)

    @Delete
    fun delete(player: Player?)

    @Query("SELECT * FROM players WHERE id = :id")
    fun loadPlayerById(id: Int): Player?

}