package com.example.cipoapp
import android.graphics.BitmapFactory
import android.os.AsyncTask
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL


private class SendfeedbackJxob(link: String) : AsyncTask<String, String, String>() {
    public var UrlSet = link;
    public var result = "";
    @Deprecated("Deprecated in Java")
    public override fun doInBackground(vararg params: String?): String {
//        Log.d("Params", params[0].toString()); val urlsSet = params[0]
        result = URL("http://fgfdhgfdfds.pythonanywhere.com/user/?link=$UrlSet").readText()
        // do above Server call here
//        Log.d("Back", result)
        return result
    }
    @Deprecated("Deprecated in Java")
    public override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        print(result)
    }
}

fun main(){
    val link = "https://square.github.io/okhttp/"
//    d().getShort2("https://square.github.io/okhttp/")
    d().getShort2(link)
}



class d{

    fun getShort2(url: String): String {
        val elem = URL("http://fgfdhgfdfds.pythonanywhere.com/user/?link=$url").readText()
        print(elem)
        return elem
    }

    fun getShort(url: String): JSONArray {
        val client = OkHttpClient()

//    print("link = ")
//    val link = readLine()!!.toString()

        val mediaType = MediaType.parse("application/json")
        val body = RequestBody.create(mediaType, "{\"destination\":\"$url\"}")
        val request = Request.Builder()
            .url("https://api.rebrandly.com/v1/links")
            .post(body)
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("apikey", "55da8157bf214ff0a2ec563234b203a6")
            .build()

        val response = client.newCall(request).execute()
        val jsondt = response.body().string(); print(jsondt)
        val jse = JSONObject(jsondt).getJSONArray("shortUrl"); println(jse)
        return jse

    }

    fun getQrCode(url: String){
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://quickchart.io/qr?text=$url")
            .build()

        val response = client.newCall(request).execute()
        val responseElem = response.body().byteStream()
        val bmp = BitmapFactory.decodeStream(responseElem)

    }


}

