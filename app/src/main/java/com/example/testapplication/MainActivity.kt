package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        val intentHome = Intent(this, HomeActivity::class.java)
        val intentRegister = Intent(this, RegisterActivity::class.java)

        val button = findViewById<Button>(R.id.btnLogin)
        val textRegister = findViewById<TextView>(R.id.textRegister)
        val txtUsername = findViewById<TextInputEditText>(R.id.txtUsername)
        val txtPassword = findViewById<TextInputEditText>(R.id.txtPassword)

        button.setOnClickListener {
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            
            if (username == "" || password == ""){
                Toast.makeText(this, "Plz Enter The Information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            intentHome.putExtra("username", "Jeet Jhaveri")
            intentHome.putExtra("password", "admin")
            intentHome.putExtra("age", "21")
            intentHome.putExtra("gender", "Male")
            startActivity(intentHome)
            finish()
        }

        textRegister.setOnClickListener{
            startActivity(intentRegister)
            finish()
        }
    }
}
