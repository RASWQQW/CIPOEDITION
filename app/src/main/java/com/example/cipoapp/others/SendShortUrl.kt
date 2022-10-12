package com.example.cipoapp.others

import android.annotation.SuppressLint
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import com.example.cipoapp.data.Stuff
import com.example.cipoapp.data.StuffViewModel
import java.lang.Exception
import java.net.URL
import java.util.*
import android.os.AsyncTask as AsyncTask1

@SuppressLint("StaticFieldLeak")
class SendShortUrl(
        link: String,
        label: TextView,
        checkBox: CheckBox,
        stuffS: StuffViewModel ) : AsyncTask1<String, String, String>() {

    private var stuffSaver = stuffS

    private var urlSet = link
    private val resultLabel2 = label
    private var checkBoxSet = checkBox

    @Deprecated("Deprecated in Java")
    public override fun doInBackground(vararg params: String?): String {
        return try {
            Log.d("Params", urlSet)
            val elem = URL("https://fgfdhgfdfds.pythonanywhere.com/user/?link=$urlSet").readText()
//            val elem = URL("https://random-word-api.herokuapp.com/word").readText()
            // do above Server call here
            Log.d("BackOver", elem)
            elem
        }catch (e: Exception){
            Log.d("Error", e.toString())
            "Error"
        }

    }

    @Deprecated("Deprecated in Java")
    public override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        resultLabel2.text = result

        resultLabel2.movementMethod = LinkMovementMethod.getInstance()

        if(resultLabel2.text.length > 15){ resultLabel2.textSize = 15F}
        if(checkBoxSet.isChecked){resultLabel2.text = resultLabel2.text.toString().uppercase()}

        fun saveCreator(){

            val getTime = Calendar.getInstance().time
            val stuff = Stuff(null, resultLabel2.text.toString(), getTime.toString())

            stuffSaver.insertItemsFun(stuff)
        }

        saveCreator()


    }

}