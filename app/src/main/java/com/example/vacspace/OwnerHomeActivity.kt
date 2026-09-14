package com.example.vacspace

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OwnerHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_owner_home)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvProfile = findViewById<TextView>(R.id.tvProfile)

        val sharedPreferences =
            getSharedPreferences("VacspaceUser", MODE_PRIVATE)

        val userName =
            sharedPreferences.getString("name", "User")

        tvWelcome.text = "Welcome back, $userName 👋"

        if (!userName.isNullOrEmpty()) {
            tvProfile.text = userName.first().uppercase()
        }
    }
}