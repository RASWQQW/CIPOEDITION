package com.example.cipoapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert
    fun insertItem(item: Stuff)

    @Query("SELECT * FROM link_story")
    fun getStuffs(): Flow<List<Stuff>>

    @Update
    fun updateStuff(stuff: Stuff)


}