package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        val intentRegister = Intent(this, RegisterActivity::class.java)
        val intentLogin = Intent(this, LoginActivity::class.java)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnRegister.setOnClickListener {
            startActivity(intentRegister)
        }

        btnLogin.setOnClickListener{
            startActivity(intentLogin)
        }
    }
}
