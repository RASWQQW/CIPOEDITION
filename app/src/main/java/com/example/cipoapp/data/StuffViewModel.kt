package com.example.cipoapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch

class StuffViewModel(application: Application): AndroidViewModel(application){

    val getCountView: LiveData<List<Notices>>
    val getAllData: LiveData<List<Stuff>>
    private  val repository: UserRepository

    init {
        val stuffDao = MainDb.getDb(application).getDao()
        repository = UserRepository(stuffDao)
        getAllData = repository.insertItem
        getCountView = repository.getCountForRep
    }

    fun deleteStuff(stuff: Stuff){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteStuff(stuff)
        }
    }

    fun insertItemsFun(stuff: Stuff){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertForRep(stuff)
        }
    }

    fun insertNoticeView(notices: Notices){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertNoticeForRep(notices)
        }
    }

    fun updateNotice(){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateNoticeForRep()
        }


    }

    fun getCountView(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getCountForRep()
        }
    }
}