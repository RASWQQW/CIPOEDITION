package com.example.cipoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cipoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main2)

        val bg = findViewById<BottomNavigationView>(R.id.bgNew34)
        bg.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemfirst -> {
                    Toast.makeText(this, "1San", Toast.LENGTH_SHORT).show()
//                    supportFragmentManager.beginTransaction().replace(com.google.android.material.R.id.container,
                //                    MainShortPage).commit()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
        }

    }
}