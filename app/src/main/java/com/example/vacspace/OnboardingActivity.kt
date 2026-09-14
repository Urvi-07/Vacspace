package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_onboarding)

        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)

        val btnNext1 = findViewById<MaterialButton>(R.id.btnNext1)
        val btnNext2 = findViewById<MaterialButton>(R.id.btnNext2)
        val btnGetStarted = findViewById<MaterialButton>(R.id.btnGetStarted)

        val btnSkip1 = findViewById<MaterialButton>(R.id.btnSkip1)
        val btnSkip2 = findViewById<MaterialButton>(R.id.btnSkip2)
        val btnSkip3 = findViewById<MaterialButton>(R.id.btnSkip3)

        btnNext1.setOnClickListener {
            viewFlipper.displayedChild = 1
        }

        btnNext2.setOnClickListener {
            viewFlipper.displayedChild = 2
        }

        btnGetStarted.setOnClickListener {
            openLogin()
        }

        btnSkip1.setOnClickListener {
            openLogin()
        }

        btnSkip2.setOnClickListener {
            openLogin()
        }

        btnSkip3.setOnClickListener {
            openLogin()
        }
    }

    private fun openLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}