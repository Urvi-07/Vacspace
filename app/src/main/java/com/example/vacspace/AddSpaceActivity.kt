package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AddSpaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_space)

        val spaceName =
            findViewById<EditText>(R.id.editTextSpaceName)

        val spaceType =
            findViewById<EditText>(R.id.editTextSpaceType)

        val location =
            findViewById<EditText>(R.id.editTextLocation)

        val area =
            findViewById<EditText>(R.id.editTextArea)

        val price =
            findViewById<EditText>(R.id.editTextPrice)

        val description =
            findViewById<EditText>(R.id.editTextDescription)

        val btnSaveSpace =
            findViewById<MaterialButton>(R.id.btnSaveSpace)

        val btnBack =
            findViewById<MaterialButton>(R.id.btnBack)

        // Save Space
        btnSaveSpace.setOnClickListener {

            val name = spaceName.text.toString().trim()
            val type = spaceType.text.toString().trim()
            val userLocation = location.text.toString().trim()
            val userArea = area.text.toString().trim()
            val userPrice = price.text.toString().trim()
            val userDescription =
                description.text.toString().trim()

            if (name.isEmpty()) {

                spaceName.error = "Enter space name"
                spaceName.requestFocus()

            } else if (type.isEmpty()) {

                spaceType.error = "Enter space type"
                spaceType.requestFocus()

            } else if (userLocation.isEmpty()) {

                location.error = "Enter location"
                location.requestFocus()

            } else if (userArea.isEmpty()) {

                area.error = "Enter area"
                area.requestFocus()

            } else if (userPrice.isEmpty()) {

                price.error = "Enter monthly price"
                price.requestFocus()

            } else if (userDescription.isEmpty()) {

                description.error = "Enter a description"
                description.requestFocus()

            } else {

                // Store space details locally
                val sharedPreferences =
                    getSharedPreferences(
                        "VacspaceSpace",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString("spaceName", name)
                    .putString("spaceType", type)
                    .putString("location", userLocation)
                    .putString("area", userArea)
                    .putString("price", userPrice)
                    .putString("description", userDescription)
                    .apply()

                Toast.makeText(
                    this,
                    "Space listed successfully",
                    Toast.LENGTH_SHORT
                ).show()

                val intent =
                    Intent(this, OwnerHomeActivity::class.java)

                startActivity(intent)
                finish()
            }
        }

        // Back button
        btnBack.setOnClickListener {

            finish()
        }
    }
}