package com.example.cipoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.data.listeners.CustomListeners
import com.example.cipoapp.databinding.CustomRawBinding
import com.example.cipoapp.fragments.list.StuffAdapters

class Custom_raw : Fragment() {
    private lateinit var binding: CustomRawBinding
    private lateinit var stuffViewModel: StuffViewModel
    private lateinit var stuffAdapters: StuffAdapters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CustomRawBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
}

}