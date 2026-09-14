package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class SeekerHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_seeker_home)

        val tvUserName =
            findViewById<TextView>(R.id.tvUserName)

        val tvProfile =
            findViewById<TextView>(R.id.tvProfile)

        val searchCard =
            findViewById<MaterialCardView>(R.id.searchCard)

        val cardSpace =
            findViewById<MaterialCardView>(R.id.cardSpace)

        val tvExploreNav =
            findViewById<TextView>(R.id.tvExploreNav)

        val tvBookingsNav =
            findViewById<TextView>(R.id.tvBookingsNav)

        val tvProfileNav =
            findViewById<TextView>(R.id.tvProfileNav)

        // Get logged-in user
        val sharedPreferences =
            getSharedPreferences(
                "VacspaceUser",
                MODE_PRIVATE
            )

        val userName =
            sharedPreferences.getString("name", "User")

        // Display user name
        tvUserName.text =
            "Find your next space, $userName"

        // Display profile initial
        if (!userName.isNullOrEmpty()) {

            tvProfile.text =
                userName.first().uppercase()
        }

        // Search Card → Explore
        searchCard.setOnClickListener {

            val intent =
                Intent(this, ExploreActivity::class.java)

            startActivity(intent)
        }

        // Available Space Card → Explore
        cardSpace.setOnClickListener {

            val intent =
                Intent(this, ExploreActivity::class.java)

            startActivity(intent)
        }

        // Explore Navigation
        tvExploreNav.setOnClickListener {

            val intent =
                Intent(this, ExploreActivity::class.java)

            startActivity(intent)
        }

        // Bookings Navigation
        tvBookingsNav.setOnClickListener {

            val intent =
                Intent(this, MyBookingsActivity::class.java)

            startActivity(intent)
        }

        // Profile Navigation
        tvProfileNav.setOnClickListener {

            // Profile screen will be added later
        }

        // Profile Circle
        tvProfile.setOnClickListener {

            // Profile screen will be added later
        }
    }
}