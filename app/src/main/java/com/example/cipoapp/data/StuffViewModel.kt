package com.example.cipoapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StuffViewModel(application: Application): AndroidViewModel(application){

    val getAllData: LiveData<List<Stuff>>
    private  val repository: UserRepository

    init {
        val stuffDao = MainDb.getDb(application).getDao()
        repository = UserRepository(stuffDao)
        getAllData = repository.insertItem
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

    fun getStuffs(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getStuffs()
        }
    }

}