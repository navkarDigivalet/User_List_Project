package com.example.user_list_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 : Button = findViewById(R.id.btn1)
        var btn2 : Button = findViewById(R.id.btn2)

        btn1.setOnClickListener {
            var intent1 = Intent(applicationContext,AddUser::class.java)
            startActivity(intent1)
        }

        btn2.setOnClickListener {
            var intent2 = Intent(applicationContext,ShowUser::class.java)
            startActivity(intent2)
        }
    }
}