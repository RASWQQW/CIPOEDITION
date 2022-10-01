package com.example.cipoapp.fragments.list

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cipoapp.FragForStory
import com.example.cipoapp.R
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.data.listeners.CustomListeners
import com.example.cipoapp.databinding.CustomRawBinding
import com.example.cipoapp.databinding.FragmentStoryBinding
import org.w3c.dom.Text
import com.example.cipoapp.fragments.StuffHolder as StuffHolder1

class StuffAdapters: RecyclerView.Adapter<StuffAdapters.MyViewHolder>(){

    private var userList = emptyList<Stuff>()
    private var actionDelete: ((Stuff) -> Unit)? = null

    class MyViewHolder(val binding: CustomRawBinding): RecyclerView.ViewHolder(binding.root){
        val actionDelete: ImageButton = binding.deleterButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        TODO("Not yet implemented")
        return MyViewHolder(CustomRawBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        TODO("Not yet implemented")
        val currentItem = userList[position]
        holder.binding.linksFor.text = currentItem.links
        holder.binding.dateTo.text = currentItem.date
        holder.binding.idFor.text = currentItem.id.toString()

        holder.actionDelete.setOnClickListener{ actionDelete?.invoke(currentItem)
            if(actionDelete == null){
                Log.d("holder", "null")
            }
        }
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(stuff: List<Stuff>){
        this.userList = stuff.reversed()
        notifyDataSetChanged()
    }

    fun setActionDelete(callback: (Stuff) -> Unit){
        this.actionDelete = callback
        Log.d("setActionDelete","Passed")
    }


}