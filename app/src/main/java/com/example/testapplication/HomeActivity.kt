package com.example.testapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_home)

        val lableUsername = findViewById<TextView>(R.id.lableUsername)
        val receivedUserData = intent.getStringExtra("username")
        lableUsername.text = "Name: $receivedUserData"

        val lablePassword = findViewById<TextView>(R.id.lablePassword)
        val receivedPasswordData = intent.getStringExtra("password")
        lablePassword.text = "Password: $receivedPasswordData"

        val lableAge = findViewById<TextView>(R.id.lableAge)
        val receivedAgeData = intent.getStringExtra("age")
        lableAge.text = "Age : $receivedAgeData"

        val lableGender = findViewById<TextView>(R.id.lableGender)
        val receivedGenderData = intent.getStringExtra("gender")
        lableGender.text = "Gender : $receivedGenderData"

        val personImage = findViewById<ImageView>(R.id.person_image)
        val btnInstagram = findViewById<ImageButton>(R.id.btnInstagram)
        val btnGithub = findViewById<ImageButton>(R.id.btnGithub)

        if(receivedGenderData == "Male" || receivedGenderData == "male")
            personImage.setImageResource(R.drawable.male_person)
        else
            personImage.setImageResource(R.drawable.female_person)


        val instaLink = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/literallyjeet/"))
        val githubLink = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Jhaveri-Jeet"))

        btnInstagram.setOnClickListener {
            startActivity(instaLink)
        }
        btnGithub.setOnClickListener {
            startActivity(githubLink)
        }
    }
}