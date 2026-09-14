package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_explore)

        val search =
            findViewById<EditText>(R.id.editTextSearch)

        val btnViewSpace1 =
            findViewById<MaterialButton>(R.id.btnViewSpace1)

        val btnViewSpace2 =
            findViewById<MaterialButton>(R.id.btnViewSpace2)

        // View first space
        btnViewSpace1.setOnClickListener {

            val intent =
                Intent(this, SpaceDetailsActivity::class.java)

            intent.putExtra("spaceName", "Premium Retail Shop")
            intent.putExtra("spaceType", "Shop")
            intent.putExtra("location", "Ahmedabad")
            intent.putExtra("area", "850")
            intent.putExtra("price", "20,000")
            intent.putExtra(
                "description",
                "A premium commercial retail space located in a convenient area of Ahmedabad. Suitable for retail stores, startups and small businesses."
            )

            startActivity(intent)
        }

        // View second space
        btnViewSpace2.setOnClickListener {

            val intent =
                Intent(this, SpaceDetailsActivity::class.java)

            intent.putExtra("spaceName", "Modern Office Studio")
            intent.putExtra("spaceType", "Office")
            intent.putExtra("location", "Ahmedabad")
            intent.putExtra("area", "1200")
            intent.putExtra("price", "28,000")
            intent.putExtra(
                "description",
                "A modern office space designed for startups, professionals and small teams. The space provides a comfortable environment for productive work."
            )

            startActivity(intent)
        }
    }
}