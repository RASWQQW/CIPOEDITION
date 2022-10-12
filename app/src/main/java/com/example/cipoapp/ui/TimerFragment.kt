package com.example.cipoapp.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.graphics.Color.GREEN
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.cipoapp.R
import com.example.cipoapp.databinding.FragmentTimerBinding

class TimerFragment : Fragment() {
    private lateinit var binding: FragmentTimerBinding
    private val CHANNEL_ID = "15"
    private val CHANNEL_NAME = "SENDER"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTimerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}