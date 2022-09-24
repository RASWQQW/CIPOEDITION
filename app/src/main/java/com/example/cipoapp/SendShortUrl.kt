package com.example.cipoapp

import android.os.AsyncTask
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import java.net.URL

class SendShortUrl(link: String, label: TextView, checkBox: CheckBox) : AsyncTask<String, String, String>() {
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