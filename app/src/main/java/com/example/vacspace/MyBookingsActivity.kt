package com.example.vacspace

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MyBookingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_bookings)

        val cardBooking =
            findViewById<MaterialCardView>(R.id.cardBooking)

        val tvEmpty =
            findViewById<TextView>(R.id.tvEmpty)

        val tvSpaceName =
            findViewById<TextView>(R.id.tvSpaceName)

        val tvLocation =
            findViewById<TextView>(R.id.tvLocation)

        val tvDate =
            findViewById<TextView>(R.id.tvDate)

        val tvDuration =
            findViewById<TextView>(R.id.tvDuration)

        val tvPrice =
            findViewById<TextView>(R.id.tvPrice)

        val tvStatus =
            findViewById<TextView>(R.id.tvStatus)

        val sharedPreferences =
            getSharedPreferences(
                "VacspaceBooking",
                MODE_PRIVATE
            )

        val spaceName =
            sharedPreferences.getString("spaceName", "")

        val location =
            sharedPreferences.getString("location", "")

        val startDate =
            sharedPreferences.getString("startDate", "")

        val duration =
            sharedPreferences.getString("duration", "")

        val price =
            sharedPreferences.getString("price", "")

        val status =
            sharedPreferences.getString("status", "")

        if (spaceName.isNullOrEmpty()) {

            cardBooking.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE

        } else {

            tvSpaceName.text = spaceName
            tvLocation.text = "📍 $location"
            tvDate.text = "📅 Start: $startDate"
            tvDuration.text = "⏱ Duration: $duration months"
            tvPrice.text = "₹$price / month"
            tvStatus.text = status?.uppercase()
        }
    }
}