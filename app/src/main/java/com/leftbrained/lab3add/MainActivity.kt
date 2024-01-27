package com.leftbrained.lab3add

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<TextInputLayout>(R.id.loginField)
        val pass = findViewById<TextInputLayout>(R.id.passField)
        val logBtn = findViewById<Button>(R.id.buttonLog)
        val signBtn = findViewById<Button>(R.id.buttonSign)

        signBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        })

        logBtn.setOnClickListener(View.OnClickListener {
            val log: String = login.editText?.text.toString()
            val password: String = pass.editText?.text.toString()
            if (TextUtils.isEmpty(log) || TextUtils.isEmpty(password)) {
                Toast.makeText(
                    this,
                    "Email or password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            val emailPattern = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{1,3}"
            if (!log.matches(emailPattern.toRegex())) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }
            else {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, ProfileScreen::class.java).putExtra("login", log))
            }
        })
    }
}