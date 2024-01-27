package com.leftbrained.lab3add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signBtn = findViewById<Button>(R.id.signButton)
        signBtn.setOnClickListener(View.OnClickListener {
            val log = findViewById<TextInputLayout>(R.id.loginField)
            val email = findViewById<TextInputLayout>(R.id.mailField)
            val pass = findViewById<TextInputLayout>(R.id.passField)
            val passConf = findViewById<TextInputLayout>(R.id.passCompleteField)

            if (TextUtils.isEmpty(log.editText?.text.toString()) ||
                TextUtils.isEmpty(pass.editText?.text.toString()) ||
                TextUtils.isEmpty(passConf.editText?.text.toString()) ||
                TextUtils.isEmpty(email.editText?.text.toString())) {
                Toast.makeText(
                    this,
                    "Email, login or password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            val emailPattern = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{1,3}"
            if (!email.editText?.text.toString().matches(emailPattern.toRegex())) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            if (pass.editText?.text.toString() != passConf.editText?.text.toString()) {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))

        })
    }
}