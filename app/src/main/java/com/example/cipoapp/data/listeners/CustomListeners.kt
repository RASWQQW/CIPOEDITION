package com.example.cipoapp.data.listeners

import com.example.cipoapp.data.Stuff

interface CustomListeners {

    fun onUpdate(stuff : Stuff, position: Int)

    fun onDelete(stuff : Stuff, position: Int)

}