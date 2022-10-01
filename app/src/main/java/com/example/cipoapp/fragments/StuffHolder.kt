package com.example.cipoapp.fragments

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.listeners.CustomListeners


abstract class StuffHolder(
    /**Main */
    private var context: Context,
    private var customListeners: CustomListeners,
    view: View
) {

    /**Data */
    private var id : Int? = null

    fun setId(id : Int) {
        this.id
    }

    fun getId() : Int{
        return id?:0
    }

    fun getContext() : Context {
        return context
    }

    fun getListener() : CustomListeners {
        return customListeners
    }

    abstract fun bindDataToViewHolder(stuff : Stuff, position : Int)
}