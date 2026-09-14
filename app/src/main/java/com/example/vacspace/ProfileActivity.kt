package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        val tvInitial =
            findViewById<TextView>(R.id.tvInitial)

        val tvName =
            findViewById<TextView>(R.id.tvName)

        val tvRole =
            findViewById<TextView>(R.id.tvRole)

        val tvEmail =
            findViewById<TextView>(R.id.tvEmail)

        val btnLogout =
            findViewById<MaterialButton>(R.id.btnLogout)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        // Get user details
        val sharedPreferences =
            getSharedPreferences(
                "VacspaceUser",
                MODE_PRIVATE
            )

        val userName =
            sharedPreferences.getString(
                "name",
                "User"
            )

        val userEmail =
            sharedPreferences.getString(
                "email",
                ""
            )

        val userRole =
            sharedPreferences.getString(
                "role",
                "Space Seeker"
            )

        // Display user details
        tvName.text = userName

        tvEmail.text = userEmail

        tvRole.text =
            userRole?.uppercase()

        // Display profile initial
        if (!userName.isNullOrEmpty()) {

            tvInitial.text =
                userName.first().uppercase()
        }

        // Logout
        btnLogout.setOnClickListener {

            val intent =
                Intent(
                    this,
                    LoginActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)

            finish()
        }

        // Back
        btnBack.setOnClickListener {

            finish()
        }
    }
}