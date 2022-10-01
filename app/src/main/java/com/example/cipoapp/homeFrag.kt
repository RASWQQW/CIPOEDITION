package com.example.cipoapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.data.listeners.CustomListeners
import com.example.cipoapp.databinding.FragmentFragForStoryBinding
import com.example.cipoapp.others.SendShortUrl


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

            stuffSaver = ViewModelProvider(this)[StuffViewModel::class.java]

            lengthText.isVisible = true; binding.imageView4.isVisible = true

            lengthText.text = printerelem.length.toString()
            Log.d("Split", printerelem.split("/")[2].toString())

            if (printerelem.split("/")[2] != "tinyurl.com"){
                SendShortUrl(printerelem, label2, label3, stuffSaver).execute()
                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.errorViewText.text = "Error, same link as tinyurl"
                binding.errorViewText.isVisible = true
            }



//            sleep to save needed text
//            Thread.sleep(5_000)
        }

    }


    override fun onUpdate(stuff: Stuff, position: Int) {
//        TODO("Not yet implemented")
    }

    override fun onDelete(stuff: Stuff, position: Int){
        stuffSaver.deleteStuff(stuff)
    }


}


