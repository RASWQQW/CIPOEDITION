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

    @Query("SELECT count FROM notices WHERE id = 0")
    fun getCount(): LiveData<List<Notices>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotice(notices: Notices)

    @Delete
    suspend fun deleteStuff(stuff: Stuff)

    @Update
    fun updateStuff(stuff: Stuff){
    }

    @Query("UPDATE notices SET count = count + 1 WHERE id = 0")
    fun updateNotice()
}