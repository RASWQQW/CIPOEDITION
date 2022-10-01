package com.example.cipoapp.data


interface BaseRepository {

    fun insert(stuff: Stuff)

    fun update(stuff: Stuff)

    fun delete(stuff: Stuff)

    fun deleteAll()
}