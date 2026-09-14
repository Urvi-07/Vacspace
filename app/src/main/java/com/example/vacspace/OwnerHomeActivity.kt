package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class OwnerHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_owner_home)

        val tvWelcome =
            findViewById<TextView>(R.id.tvWelcome)

        val tvProfile =
            findViewById<TextView>(R.id.tvProfile)

        val cardAddSpace =
            findViewById<MaterialCardView>(R.id.cardAddSpace)

        val cardMySpaces =
            findViewById<MaterialCardView>(R.id.cardMySpaces)

        val cardBookingRequests =
            findViewById<MaterialCardView>(
                R.id.cardBookingRequests
            )

        val tvSpacesNav =
            findViewById<TextView>(R.id.tvSpacesNav)

        val tvRequestsNav =
            findViewById<TextView>(R.id.tvRequestsNav)

        val tvProfileNav =
            findViewById<TextView>(R.id.tvProfileNav)

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

        // Display welcome message
        tvWelcome.text =
            "Welcome back, $userName 👋"

        // Display profile initial
        if (!userName.isNullOrEmpty()) {

            tvProfile.text =
                userName.first().uppercase()
        }

        // Add Space
        cardAddSpace.setOnClickListener {

            val intent =
                Intent(
                    this,
                    AddSpaceActivity::class.java
                )

            startActivity(intent)
        }

        // My Spaces
        cardMySpaces.setOnClickListener {

            val intent =
                Intent(
                    this,
                    MySpacesActivity::class.java
                )

            startActivity(intent)
        }

        // Booking Requests
        cardBookingRequests.setOnClickListener {

            val intent =
                Intent(
                    this,
                    BookingRequestsActivity::class.java
                )

            startActivity(intent)
        }

        // My Spaces Navigation
        tvSpacesNav.setOnClickListener {

            val intent =
                Intent(
                    this,
                    MySpacesActivity::class.java
                )

            startActivity(intent)
        }

        // Booking Requests Navigation
        tvRequestsNav.setOnClickListener {

            val intent =
                Intent(
                    this,
                    BookingRequestsActivity::class.java
                )

            startActivity(intent)
        }

        // Profile Navigation
        tvProfileNav.setOnClickListener {

            val intent =
                Intent(
                    this,
                    ProfileActivity::class.java
                )

            startActivity(intent)
        }

        // Profile Circle
        tvProfile.setOnClickListener {

            val intent =
                Intent(
                    this,
                    ProfileActivity::class.java
                )

            startActivity(intent)
        }
    }
}