package com.example.cipoapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.asLiveData
import com.example.cipoapp.databinding.FragmentFragForStoryBinding
import java.util.*


class homeFrag : Fragment() {
    lateinit var binding: FragmentFragForStoryBinding

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
//            binding.setButton2.animate().apply{
//                duration = 1000
//                rotationY(360f)
//            }.start()

            val printerelem = binding.editTextTextPersonName3.text.toString()
            val label2 = binding.eeee3
            val label3 = binding.checkBoxc3
            val lengthText = binding.crew3


            lengthText.isVisible = true; binding.imageView4.isVisible = true
            lengthText.text = printerelem.length.toString();
            SendShortUrl(printerelem, label2, label3).execute()

        }
    }

    private fun insertStuffs(stuff: Stuff){
        
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

}


