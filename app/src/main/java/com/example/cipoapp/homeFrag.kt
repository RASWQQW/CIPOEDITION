package com.example.cipoapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.data.listeners.CustomListeners
import com.example.cipoapp.databinding.FragmentFragForStoryBinding
import com.example.cipoapp.fragments.list.StuffAdapters
import com.example.cipoapp.others.SendShortUrl
import java.lang.Exception
import java.util.*


class homeFrag : Fragment(), CustomListeners {
    lateinit var binding: FragmentFragForStoryBinding
    private lateinit var stuffSaver: StuffViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFragForStoryBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, save: Bundle?) {

        binding.copyButton2.setOnClickListener{
            val myClipboard = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;
            val clipped = ClipData.newPlainText("text", binding.eeee3.text)
            myClipboard?.setPrimaryClip(clipped);
            Toast.makeText(activity, "Text Copied", Toast.LENGTH_SHORT).show()
        }

        binding.setButton2.setOnClickListener {
            binding.setButton2.animate().apply{
                duration = 1000
                rotationY(360f)
            }.start()

            val printerelem = binding.editTextTextPersonName3.text.toString()
            val label2 = binding.eeee3
            val label3 = binding.checkBoxc3
            val lengthText = binding.crew3

            lengthText.isVisible = true; binding.imageView4.isVisible = true
            lengthText.text = printerelem.length.toString()

            stuffSaver = ViewModelProvider(this)[StuffViewModel::class.java]

            fun runGetLinks(){
                SendShortUrl(printerelem, label2, label3, stuffSaver).execute()
                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
            }

            val splitEdElem = printerelem.split("/")

            try{
                if(splitEdElem.size >= 2){
                    if (splitEdElem[2] == "tinyurl.com"){
                        binding.errorViewText.text = "Error, same link as tinyurl"
                        binding.errorViewText.isVisible = true
                        binding.iconAnimate.isVisible = true }

                    else{ runGetLinks() }
                    binding.errorViewText.isGone = true
                    binding.iconAnimate.isGone = true  }

                else if(printerelem.length < 10){
                    binding.errorViewText.text = "Text too short"
                    binding.errorViewText.isVisible = true
                    binding.iconAnimate.isVisible = true }

                else{ runGetLinks();
                    binding.errorViewText.isGone = true
                    binding.iconAnimate.isGone = true  }

            }
            catch (e: Exception){
                binding.errorViewText.text = e.toString()
                binding.errorViewText.isGone = true
                binding.iconAnimate.isGone = true

            }
        }
    }

    override fun onUpdate(stuff: Stuff, position: Int) {
//        TODO("Not yet implemented")
    }

    override fun onDelete(stuff: Stuff, position: Int){
        stuffSaver.deleteStuff(stuff)
    }


}


