package com.example.cipoapp.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class UserRepository(private val dao: Dao){
    val insertItem: LiveData<List<Stuff>> = dao.getStuffs()
    val getCountForRep: LiveData<List<Notices>> = dao.getCount()

    suspend fun insertForRep(stuff: Stuff){
        dao.insertItem(stuff)
    }

    suspend fun deleteStuff(stuff: Stuff){
        dao.deleteStuff(stuff)
    }

    suspend fun insertNoticeForRep(notices: Notices){
        dao.insertNotice(notices)
    }
    suspend fun updateNoticeForRep(){
        dao.updateNotice()
    }

    suspend fun getCountForRep(){
        dao.getCount()
    }

}