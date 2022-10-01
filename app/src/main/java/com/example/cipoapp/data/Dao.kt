package com.example.cipoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.cipoapp.data.Stuff
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Stuff)

    @Query("SELECT * FROM link_story")
    fun getStuffs(): LiveData<List<Stuff>>

    @Query("DELETE FROM link_story WHERE id = :id")
    fun deleteAlStuff(id: Int?)

    @Delete
    suspend fun deleteStuff(stuff: Stuff)

    @Update
    fun updateStuff(stuff: Stuff){

    }




}