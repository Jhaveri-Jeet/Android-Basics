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

        val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
        val userId = prefs.getInt("user_id", 0)
        val intentLogin = Intent(this, LoginActivity::class.java)

        if(userId == 0){
            startActivity(intentLogin)
            finish()
        }

        val intentRegister = Intent(this, RegisterActivity::class.java)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        findViewById<Button>(R.id.btnLogOut).setOnClickListener{
            val editor = prefs.edit()
            editor.remove("user_id")
            editor.apply()

            startActivity(intentLogin)
        }

        btnRegister.setOnClickListener {
            startActivity(intentRegister)
        }

    }
}
