package com.example.cipoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cipoapp.R
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.databinding.CustomRawBinding

class ListAdapters: ListAdapter<Stuff, ListAdapters.MyViewHold>(StuffComparator()) {

    private var stuffsFor = emptyList<Stuff>()

    class MyViewHold(private val binding: CustomRawBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stuff: Stuff) = with(binding) {
//            textView3.text = stuff.links

        }
        companion object {
            fun create(parent: ViewGroup): MyViewHold {
                return MyViewHold(
                    CustomRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHold {
//        TODO("Not yet implemented")
        return MyViewHold.create(parent)
    }


    override fun onBindViewHolder(holder: MyViewHold, position: Int) {
//        TODO("Not yet implemented")
        return holder.bind(getItem(position))
    }

    class StuffComparator : DiffUtil.ItemCallback<Stuff>(){

        override fun areItemsTheSame(oldItem: Stuff, newItem: Stuff): Boolean {
//            TODO("Not yet implemented")
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stuff, newItem: Stuff): Boolean {
//            TODO("Not yet implemented")
            return oldItem == newItem
        }
    }
}



