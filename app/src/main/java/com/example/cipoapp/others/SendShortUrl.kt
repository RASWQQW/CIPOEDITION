package com.example.cipoapp.others

import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.cipoapp.MainActivity
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.homeFrag
import java.lang.ref.WeakReference
import java.net.URL
import java.util.*
import android.os.AsyncTask as AsyncTask1

class SendShortUrl(link: String, label: TextView, checkBox: CheckBox, stuffS: StuffViewModel) : AsyncTask1<String, String, String>() {
    private var stuffSaver = stuffS
    private lateinit var activityFor: homeFrag

    private var UrlSet = link
    private var result = ""
    private val resultLabel2 = label
    private var checkBoxset = checkBox

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

        fun saveCreator(){
            activityFor = homeFrag()

            val getTime = Calendar.getInstance().time
            val stuff = Stuff(null, resultLabel2.text.toString(), getTime.toString())

            stuffSaver.insertItemsFun(stuff)
        }

        saveCreator()


    }

}