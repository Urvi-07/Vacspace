package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.editTextName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val confirmPassword =
            findViewById<EditText>(R.id.editTextConfirmPassword)

        val seekerCard =
            findViewById<MaterialCardView>(R.id.cardSeeker)

        val ownerCard =
            findViewById<MaterialCardView>(R.id.cardOwner)

        val btnCreateAccount =
            findViewById<MaterialButton>(R.id.btnCreateAccount)

        val tvLogin =
            findViewById<TextView>(R.id.tvLogin)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        var selectedRole = "Space Seeker"

        // Space Seeker selected by default
        seekerCard.strokeWidth = 4
        ownerCard.strokeWidth = 1

        // Select Space Seeker
        seekerCard.setOnClickListener {

            selectedRole = "Space Seeker"

            seekerCard.strokeWidth = 4
            ownerCard.strokeWidth = 1
        }

        // Select Space Owner
        ownerCard.setOnClickListener {

            selectedRole = "Space Owner"

            ownerCard.strokeWidth = 4
            seekerCard.strokeWidth = 1
        }

        // Create Account
        btnCreateAccount.setOnClickListener {

            val userName = name.text.toString().trim()
            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString()
            val userConfirmPassword =
                confirmPassword.text.toString()

            if (userName.isEmpty()) {

                name.error = "Enter your full name"
                name.requestFocus()

            } else if (userEmail.isEmpty()) {

                email.error = "Enter your email"
                email.requestFocus()

            } else if (userPassword.isEmpty()) {

                password.error = "Enter your password"
                password.requestFocus()

            } else if (userPassword.length < 6) {

                password.error =
                    "Password must contain at least 6 characters"
                password.requestFocus()

            } else if (userConfirmPassword.isEmpty()) {

                confirmPassword.error =
                    "Confirm your password"
                confirmPassword.requestFocus()

            } else if (userPassword != userConfirmPassword) {

                confirmPassword.error =
                    "Passwords do not match"
                confirmPassword.requestFocus()

            } else {

                // Save account locally
                val sharedPreferences =
                    getSharedPreferences("VacspaceUser", MODE_PRIVATE)

                sharedPreferences.edit()
                    .putString("name", userName)
                    .putString("email", userEmail)
                    .putString("password", userPassword)
                    .putString("role", selectedRole)
                    .apply()

                Toast.makeText(
                    this,
                    "Account created successfully",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Already have an account
        tvLogin.setOnClickListener {

            finish()
        }

        // Back button
        btnBack.setOnClickListener {

            finish()
        }
    }
}