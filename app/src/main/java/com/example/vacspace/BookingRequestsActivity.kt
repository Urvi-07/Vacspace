package com.example.vacspace

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class BookingRequestsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_booking_requests)

        val cardRequest =
            findViewById<MaterialCardView>(R.id.cardRequest)

        val tvEmpty =
            findViewById<TextView>(R.id.tvEmpty)

        val tvStatus =
            findViewById<TextView>(R.id.tvStatus)

        val tvSpaceName =
            findViewById<TextView>(R.id.tvSpaceName)

        val tvSeeker =
            findViewById<TextView>(R.id.tvSeeker)

        val tvDate =
            findViewById<TextView>(R.id.tvDate)

        val tvDuration =
            findViewById<TextView>(R.id.tvDuration)

        val tvMessage =
            findViewById<TextView>(R.id.tvMessage)

        val tvPrice =
            findViewById<TextView>(R.id.tvPrice)

        val btnAccept =
            findViewById<MaterialButton>(R.id.btnAccept)

        val btnReject =
            findViewById<MaterialButton>(R.id.btnReject)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        // Read booking request
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

        val message =
            sharedPreferences.getString("message", "")

        val status =
            sharedPreferences.getString("status", "")

        // Show request if available
        if (spaceName.isNullOrEmpty()) {

            cardRequest.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE

        } else {

            tvSpaceName.text = spaceName

            tvSeeker.text =
                "Requested by: Space Seeker"

            tvDate.text =
                "📅 Start: $startDate"

            tvDuration.text =
                "⏱ Duration: $duration months"

            tvMessage.text = message

            tvPrice.text =
                "₹$price / month"

            tvStatus.text =
                status?.uppercase()
        }

        // Accept booking
        btnAccept.setOnClickListener {

            sharedPreferences.edit()
                .putString("status", "Accepted")
                .apply()

            tvStatus.text = "ACCEPTED"

            Toast.makeText(
                this,
                "Booking request accepted",
                Toast.LENGTH_SHORT
            ).show()

            btnAccept.visibility = View.GONE
            btnReject.visibility = View.GONE
        }

        // Reject booking
        btnReject.setOnClickListener {

            sharedPreferences.edit()
                .putString("status", "Rejected")
                .apply()

            tvStatus.text = "REJECTED"

            Toast.makeText(
                this,
                "Booking request rejected",
                Toast.LENGTH_SHORT
            ).show()

            btnAccept.visibility = View.GONE
            btnReject.visibility = View.GONE
        }

        // Back
        btnBack.setOnClickListener {

            finish()
        }
    }
}