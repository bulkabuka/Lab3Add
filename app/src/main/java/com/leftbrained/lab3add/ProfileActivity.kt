package com.leftbrained.lab3add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val login = intent.getStringExtra("login")
        val nameText = findViewById<TextView>(R.id.nameText)
        nameText.text = login.toString()
    }
}