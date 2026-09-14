package com.example.vacspace

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MySpacesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_spaces)

        val cardSpace =
            findViewById<MaterialCardView>(R.id.cardSpace)

        val tvEmpty =
            findViewById<TextView>(R.id.tvEmpty)

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

        val sharedPreferences =
            getSharedPreferences("VacspaceSpace", MODE_PRIVATE)

        val spaceName =
            sharedPreferences.getString("spaceName", "")

        val spaceType =
            sharedPreferences.getString("spaceType", "")

        val location =
            sharedPreferences.getString("location", "")

        val area =
            sharedPreferences.getString("area", "")

        val price =
            sharedPreferences.getString("price", "")

        if (spaceName.isNullOrEmpty()) {

            cardSpace.visibility = android.view.View.GONE
            tvEmpty.visibility = android.view.View.VISIBLE

        } else {

            tvSpaceName.text = spaceName
            tvSpaceType.text = spaceType
            tvLocation.text = location
            tvArea.text = "$area sq.ft"
            tvPrice.text = "₹$price / month"
        }
    }
}