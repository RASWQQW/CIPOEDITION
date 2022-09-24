package com.example.cipoapp

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import com.example.cipoapp.databinding.ActivityMainBinding
import com.example.cipoapp.SendShortUrl
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    lateinit var determine : d
    val clipped: ClipData? = null

    private lateinit var mainFrags : homeFrag
    private lateinit var storyFrags : fragForStory


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(safe: Bundle?) {
        super.onCreate(safe)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        mainFrags = homeFrag()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, mainFrags)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bindingClass.bgNew34.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemfirst -> {
                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, MainActivity2::class.java))

                    mainFrags = homeFrag()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, mainFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.itemnext -> {
                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
                    storyFrags = fragForStory()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, storyFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }


    override fun onStart(){
        super.onStart()
        Log.d("Check", "onStart")

    }

    override fun onResume(){
        super.onResume()
        Log.d("Check", "onResume")

    }

    override fun onPause(){
        super.onPause()
        Log.d("Check", "onPause")

    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("Check", "onDestroy")

    }

    override fun onStop(){
        super.onStop()
        Log.d("Check", "onStop")

    }

    override fun onRestart(){
        super.onRestart()
        Log.d("Check", "onRestart")

    }

}