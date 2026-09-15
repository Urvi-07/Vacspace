package com.example.vacspace

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.button.MaterialButton

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_explore)

        val search =
            findViewById<EditText>(R.id.editTextSearch)

        val cardShop =
            findViewById<MaterialCardView>(R.id.cardShop)

        val cardOffice =
            findViewById<MaterialCardView>(R.id.cardOffice)

        val cardSpace1 =
            findViewById<MaterialCardView>(R.id.cardSpace1)

        val cardSpace2 =
            findViewById<MaterialCardView>(R.id.cardSpace2)

        val btnViewSpace1 =
            findViewById<MaterialButton>(R.id.btnViewSpace1)

        val btnViewSpace2 =
            findViewById<MaterialButton>(R.id.btnViewSpace2)

        // Search functionality
        search.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                val query =
                    s.toString().trim().lowercase()

                if (query.isEmpty()) {

                    cardSpace1.visibility = View.VISIBLE
                    cardSpace2.visibility = View.VISIBLE

                } else {

                    val space1Matches =
                        "premium retail shop shop ahmedabad".contains(
                            query
                        )

                    val space2Matches =
                        "modern office studio office ahmedabad".contains(
                            query
                        )

                    cardSpace1.visibility =
                        if (space1Matches) {
                            View.VISIBLE
                        } else {
                            View.GONE
                        }

                    cardSpace2.visibility =
                        if (space2Matches) {
                            View.VISIBLE
                        } else {
                            View.GONE
                        }
                }
            }

            override fun afterTextChanged(
                s: Editable?
            ) {
            }
        })

        // Shop category
        cardShop.setOnClickListener {

            search.setText("shop")
        }

        // Office category
        cardOffice.setOnClickListener {

            search.setText("office")
        }

        // View first space
        btnViewSpace1.setOnClickListener {

            val intent =
                Intent(
                    this,
                    SpaceDetailsActivity::class.java
                )

            intent.putExtra(
                "spaceName",
                "Premium Retail Shop"
            )

            intent.putExtra(
                "spaceType",
                "Shop"
            )

            intent.putExtra(
                "location",
                "Ahmedabad"
            )

            intent.putExtra(
                "area",
                "850"
            )

            intent.putExtra(
                "price",
                "20,000"
            )

            intent.putExtra(
                "description",
                "A premium commercial retail space located in a convenient area of Ahmedabad. Suitable for retail stores, startups and small businesses."
            )

            startActivity(intent)
        }

        // View second space
        btnViewSpace2.setOnClickListener {

            val intent =
                Intent(
                    this,
                    SpaceDetailsActivity::class.java
                )

            intent.putExtra(
                "spaceName",
                "Modern Office Studio"
            )

            intent.putExtra(
                "spaceType",
                "Office"
            )

            intent.putExtra(
                "location",
                "Ahmedabad"
            )

            intent.putExtra(
                "area",
                "1200"
            )

            intent.putExtra(
                "price",
                "28,000"
            )

            intent.putExtra(
                "description",
                "A modern office space designed for startups, professionals and small teams. The space provides a comfortable environment for productive work."
            )

            startActivity(intent)
        }
    }
}