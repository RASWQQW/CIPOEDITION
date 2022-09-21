package com.example.cipoapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import com.example.cipoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    lateinit var determine : d
    val clipped: ClipData? = null

    private lateinit var mainFrags : homeFrag
    private lateinit var storyFrags : storyFrag


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(safe: Bundle?) {
        super.onCreate(safe)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        mainFrags = homeFrag()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, mainFrags)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bg = findViewById<TextView>(R.id.Textters)

        bindingClass.bgNew34.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemfirst -> {
                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
//                    supportFragmentManager.beginTransaction().replace(com.google.android.material.
//                    R.id.container, storyShorter ).commit()
//                    startActivity(Intent(this, MainActivity2::class.java))

                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()

                    mainFrags = homeFrag()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, mainFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.itemnext ->{
                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
                    storyFrags = storyFrag()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, storyFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
            }
            true
        }

        Log.d("Check", "onCreate")


        bindingClass.SetButton.setOnClickListener{
                bindingClass.SetButton.animate().apply{
                    duration = 1000
                    rotationY(360f)
                }.start()

            val printerelem = bindingClass.editTextTextPersonName.text.toString()
            val label2 = bindingClass.eeee
            val label3 = bindingClass.checkBoxc
            val lengthText = bindingClass.Crew

            lengthText.isVisible = true
            lengthText.text = printerelem.length.toString();
            SendShortUrl(printerelem, label2, label3).execute()

        }

        bindingClass.CopyButton.setOnClickListener{
            val myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;
            val clipped = ClipData.newPlainText("text", bindingClass.eeee.text)
            myClipboard?.setPrimaryClip(clipped);
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show()
        }
    }

private class SendShortUrl(link: String, label: TextView, checkBox: CheckBox) : AsyncTask<String, String, String>() {
        var UrlSet = link;  var result = ""; val resultLabel2 = label; var checkBoxset = checkBox

        @Deprecated("Deprecated in Java")
        public override fun doInBackground(vararg params: String?): String {
            Log.d("Params", UrlSet)
            result = URL("https://fgfdhgfdfds.pythonanywhere.com/user/?link=$UrlSet").readText()
            // do above Server call here
            Log.d("Backss", result)
            return result
        }

        @Deprecated(
            "Deprecated in Java",
            ReplaceWith("super.onPostExecute(result)", "android.os.AsyncTask")
        )
        public override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            resultLabel2.text = result
            resultLabel2.movementMethod = LinkMovementMethod.getInstance()

            if(resultLabel2.text.length > 15){ resultLabel2.textSize = 15F}
            if(checkBoxset.isChecked){resultLabel2.text = resultLabel2.text.toString().uppercase()}



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