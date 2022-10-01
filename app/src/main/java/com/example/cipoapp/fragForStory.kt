package com.example.cipoapp

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.cipoapp.data.MainDb
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.databinding.ActivityMain2Binding.inflate
import com.example.cipoapp.databinding.ActivityMainBinding.inflate
import com.example.cipoapp.databinding.FragmentFragForStoryBinding
import com.example.cipoapp.databinding.FragmentStoryBinding
import com.example.cipoapp.fragments.list.ListAdapters
import com.example.cipoapp.fragments.list.StuffAdapters

class FragForStory : Fragment() {
    private lateinit var stuffModel: StuffViewModel
    private lateinit var binding: FragmentStoryBinding
    private lateinit var adapter: StuffAdapters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStoryBinding.inflate(inflater)

        val adapter = StuffAdapters()
        val recyclerView = binding.rview
//        binding.rview.scrollToPosition(1)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

//      UserViewModel
        stuffModel = ViewModelProvider(this)[StuffViewModel::class.java]
        stuffModel.getAllData.observe(viewLifecycleOwner, Observer{user ->
            adapter.setData(user)
        })


        adapter.setActionDelete{
            Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(activity, R.style.ForAlert)
                builder.setMessage("Are you sure?")

                builder.setPositiveButton("YES") { p0, _ ->
                    stuffModel.deleteStuff(it)

                    stuffModel.getAllData.observe(viewLifecycleOwner, Observer{ user ->
                        adapter.setData(user)

                    })
                    p0.dismiss()
                }
                builder.setNegativeButton("NO"){p0, _ ->
                    p0.dismiss()
                }

                builder.create().show()
    }

        return binding.root
    }

    override fun onResume(){
        super.onResume()

    }
}