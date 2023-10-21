package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_register)

        val intentHome = Intent(this, HomeActivity::class.java)
        val intentMain = Intent(this, MainActivity::class.java)

        val button = findViewById<Button>(R.id.btnRegister)
        val textLogin = findViewById<TextView>(R.id.textLogin)
        val txtUsername = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.txtUsername)
        val txtPassword = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.txtPassword)
        val txtAge = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.txtAge)
        val txtGender = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.txtGender)

        button.setOnClickListener {
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            val age = txtAge.text.toString()
            val gender = txtGender.text.toString()

            if (username == "" || password == "" || age == "" || gender == "") {
                Toast.makeText(this, "Plz Enter The Information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intentHome.putExtra("username", username)
            intentHome.putExtra("password", password)
            intentHome.putExtra("age", age)
            intentHome.putExtra("gender", gender)
            startActivity(intentHome)
            finish()
        }

        textLogin.setOnClickListener {
            startActivity(intentMain)
            finish()
        }
    }
}