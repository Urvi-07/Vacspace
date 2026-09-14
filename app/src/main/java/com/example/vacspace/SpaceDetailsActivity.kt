package com.example.vacspace

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SpaceDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_space_details)

        val tvSpaceName =
            findViewById<TextView>(R.id.tvSpaceName)

        val tvSpaceType =
            findViewById<TextView>(R.id.tvSpaceType)

        val tvLocation =
            findViewById<TextView>(R.id.tvLocation)

        val tvArea =
            findViewById<TextView>(R.id.tvArea)

        val tvPrice =
            findViewById<TextView>(R.id.tvPrice)

        val tvDescription =
            findViewById<TextView>(R.id.tvDescription)

        val btnRequestBooking =
            findViewById<MaterialButton>(R.id.btnRequestBooking)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        // Receive space details
        val spaceName =
            intent.getStringExtra("spaceName")

        val spaceType =
            intent.getStringExtra("spaceType")

        val location =
            intent.getStringExtra("location")

        val area =
            intent.getStringExtra("area")

        val price =
            intent.getStringExtra("price")

        val description =
            intent.getStringExtra("description")

        // Display details
        tvSpaceName.text = spaceName
        tvSpaceType.text = spaceType?.uppercase()
        tvLocation.text = "📍 $location"
        tvArea.text = "📐 $area sq.ft"
        tvPrice.text = "₹$price / month"
        tvDescription.text = description

        // Request Booking
        btnRequestBooking.setOnClickListener {

            val intent =
                android.content.Intent(
                    this,
                    BookingActivity::class.java
                )

            intent.putExtra("spaceName", spaceName)
            intent.putExtra("location", location)
            intent.putExtra("area", area)
            intent.putExtra("price", price)

            startActivity(intent)
        }

        // Back
        btnBack.setOnClickListener {

            finish()
        }
    }
}