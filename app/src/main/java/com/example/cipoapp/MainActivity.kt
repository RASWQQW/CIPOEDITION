package com.example.cipoapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipData
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.*
import com.example.cipoapp.data.Notices
import com.example.cipoapp.data.StuffViewModel
import com.example.cipoapp.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity(){
    private lateinit var bindingClass : ActivityMainBinding
    lateinit var determine : d
    val clipped: ClipData? = null

    private val CHANNEL_ID = "ALMA"
    private val CHANNEL_NAME = "WOOW"
    private val NOTIFICATION_ID = 0


    private lateinit var mainFrags : homeFrag
    private lateinit var storyFrags : FragForStory
    private lateinit var stuffModel: StuffViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(safe: Bundle?) {
        super.onCreate(safe)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

//        Notification fun
        createNotificationChannel()


        mainFrags = homeFrag()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, mainFrags)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bindingClass.bgNew34.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemfirst -> {
//                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, MainActivity2::class.java))
                    mainFrags = homeFrag()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, mainFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.itemnext -> {
//                    Toast.makeText(this, "2San", Toast.LENGTH_SHORT).show()
                    storyFrags = FragForStory()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, storyFrags)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }


        fun sendNotificationOne(){

            stuffModel = ViewModelProvider(this)[StuffViewModel::class.java]

            try {

                fun pushNotification(list: List<Notices>) {

                    val contentIntent = Intent(applicationContext, MainActivity::class.java)
                    val contentPendingIntent = PendingIntent.getActivity( applicationContext,
                        NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_IMMUTABLE
                    )

                    val mainText: String; val mainTitle: String

                    Log.d("ListMain", list[0].count.toString())

                    if(list[0].count > 5){ mainTitle = "Hi";  mainText = "Whats going on!"  }
                    else{ mainTitle = "Hello";  mainText = "Thanks for joining!" }

                    val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.logoin)
                        .setContentTitle(mainTitle)
                        .setContentText(mainText)
                        .setStyle(NotificationCompat.BigTextStyle())
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(contentPendingIntent)
                        .build()

                    NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder)
                }

                fun addCount(){
                    stuffModel.updateNotice()
                }

                fun countBill(count: List<Notices>){
                    if(count.isEmpty()){
                        val notice = Notices(NOTIFICATION_ID, 0)
                        stuffModel.insertNoticeView(notice)
                    }
                }

                stuffModel.getCountView.observe(this, Observer {
                    countBill(it)
                    pushNotification(it)} )
                addCount()


            }catch (e: Exception){
                Log.d("Count", e.toString())
            }

        }

        sendNotificationOne()

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH).apply{
                lightColor = Color.BLUE
                enableLights(true)
                setShowBadge(true)
            }
            val manager = ContextCompat.getSystemService(
                this, NotificationManager::class.java) as NotificationManager
            manager.createNotificationChannel(channel)
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