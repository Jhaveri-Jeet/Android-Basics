package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.password)
        val intentMain = Intent(this, MainActivity::class.java)

        findViewById<Button>(R.id.button).setOnClickListener{
            val userData = username.text.toString()
            val passData = password.text.toString()

            if (userData == "" || passData == "" )
                return@setOnClickListener

            val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putInt("user_id", 1)
            editor.apply()

            startActivity(intentMain)
            finish()
        }
    }
}