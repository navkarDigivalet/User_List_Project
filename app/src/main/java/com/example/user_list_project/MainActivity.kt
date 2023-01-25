package com.example.user_list_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 : Button = findViewById(R.id.btn1)
        val btn2 : Button = findViewById(R.id.btn2)

        btn1.setOnClickListener {
            val intent1 = Intent(applicationContext,AddUser::class.java)
            startActivity(intent1)
        }

        btn2.setOnClickListener {
            val intent2 = Intent(applicationContext,ShowUser::class.java)
            startActivity(intent2)
        }

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar)

        setSupportActionBar(toolbar)
    }
}