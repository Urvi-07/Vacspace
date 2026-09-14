package com.example.vacspace

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.util.Calendar

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_booking)

        val tvSpaceName =
            findViewById<android.widget.TextView>(R.id.tvSpaceName)

        val tvLocation =
            findViewById<android.widget.TextView>(R.id.tvLocation)

        val tvArea =
            findViewById<android.widget.TextView>(R.id.tvArea)

        val tvPrice =
            findViewById<android.widget.TextView>(R.id.tvPrice)

        val startDate =
            findViewById<EditText>(R.id.editTextStartDate)

        val duration =
            findViewById<EditText>(R.id.editTextDuration)

        val message =
            findViewById<EditText>(R.id.editTextMessage)

        val btnSubmit =
            findViewById<MaterialButton>(R.id.btnSubmitBooking)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        // Receive space details
        val spaceName =
            intent.getStringExtra("spaceName")

        val location =
            intent.getStringExtra("location")

        val area =
            intent.getStringExtra("area")

        val price =
            intent.getStringExtra("price")

        // Display space details
        tvSpaceName.text = spaceName
        tvLocation.text = "📍 $location"
        tvArea.text = "📐 $area sq.ft"
        tvPrice.text = "₹$price / month"

        // Date Picker
        startDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val selectedDate =
                        "$selectedDay/${selectedMonth + 1}/$selectedYear"

                    startDate.setText(selectedDate)
                },
                year,
                month,
                day
            )

            datePicker.show()
        }

        // Submit Booking
        btnSubmit.setOnClickListener {

            val selectedDate =
                startDate.text.toString().trim()

            val bookingDuration =
                duration.text.toString().trim()

            val bookingMessage =
                message.text.toString().trim()

            if (selectedDate.isEmpty()) {

                startDate.error = "Select start date"
                startDate.requestFocus()

            } else if (bookingDuration.isEmpty()) {

                duration.error = "Enter duration"
                duration.requestFocus()

            } else if (bookingMessage.isEmpty()) {

                message.error = "Enter a message"
                message.requestFocus()

            } else {

                // Save booking locally
                val sharedPreferences =
                    getSharedPreferences(
                        "VacspaceBooking",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString("spaceName", spaceName)
                    .putString("location", location)
                    .putString("area", area)
                    .putString("price", price)
                    .putString("startDate", selectedDate)
                    .putString("duration", bookingDuration)
                    .putString("message", bookingMessage)
                    .putString("status", "Pending")
                    .apply()

                Toast.makeText(
                    this,
                    "Booking request sent successfully",
                    Toast.LENGTH_SHORT
                ).show()

                val intent =
                    Intent(this, SeekerHomeActivity::class.java)

                startActivity(intent)
                finish()
            }
        }

        // Back
        btnBack.setOnClickListener {

            finish()
        }
    }
}