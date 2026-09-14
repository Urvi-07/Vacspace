package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)

        val btnLogin =
            findViewById<MaterialButton>(R.id.btnLogin)

        val tvRegister =
            findViewById<TextView>(R.id.tvRegister)

        val tvBack =
            findViewById<TextView>(R.id.tvBack)

        // Login
        btnLogin.setOnClickListener {

            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString()

            if (userEmail.isEmpty()) {

                email.error = "Enter your email"
                email.requestFocus()

            } else if (userPassword.isEmpty()) {

                password.error = "Enter your password"
                password.requestFocus()

            } else {

                val sharedPreferences =
                    getSharedPreferences("VacspaceUser", MODE_PRIVATE)

                val savedEmail =
                    sharedPreferences.getString("email", "")

                val savedPassword =
                    sharedPreferences.getString("password", "")

                val savedRole =
                    sharedPreferences.getString("role", "")

                if (userEmail == savedEmail &&
                    userPassword == savedPassword
                ) {

                    Toast.makeText(
                        this,
                        "Login successful",
                        Toast.LENGTH_SHORT
                    ).show()

                    if (savedRole == "Space Seeker") {

                        val intent =
                            Intent(this, SeekerHomeActivity::class.java)

                        startActivity(intent)

                    } else if (savedRole == "Space Owner") {

                        val intent =
                            Intent(this, OwnerHomeActivity::class.java)

                        startActivity(intent)
                    }

                    finish()

                } else {

                    Toast.makeText(
                        this,
                        "Invalid email or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        // Create Account
        tvRegister.setOnClickListener {

            val intent =
                Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }

        // Back
        tvBack.setOnClickListener {

            finish()
        }
    }
}