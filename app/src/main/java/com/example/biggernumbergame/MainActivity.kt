package com.example.biggernumbergame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var tvPoints: TextView
    private var totalPoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        tvPoints = findViewById(R.id.tvPoints)

        randomNumber()
        tvPoints.text = "Points: $totalPoints"


        btnLeft.setOnClickListener {
            val left = Integer.parseInt(btnLeft.text.toString())
            val right = Integer.parseInt(btnRight.text.toString())
            if (left >= right) {
                totalPoints++
                Toast.makeText(this, "Hurray!!!", Toast.LENGTH_SHORT).show()
            }else {
                totalPoints--
                Toast.makeText(this, "Alas", Toast.LENGTH_SHORT).show()
            }
            tvPoints.text = totalPoints.toString()
            randomNumber()
        }

        btnRight.setOnClickListener {
            val left = Integer.parseInt(btnLeft.text.toString())
            val right = Integer.parseInt(btnRight.text.toString())
            if (right >= left) {
                totalPoints++
                Toast.makeText(this, "Hurray!!!", Toast.LENGTH_SHORT).show()
            }else {
                totalPoints--
                Toast.makeText(this, "Alas", Toast.LENGTH_SHORT).show()
            }
            tvPoints.text = totalPoints.toString()
            randomNumber()
        }
    }

    private fun randomNumber() {
        val random1 = Random().nextInt(101)
        var random2 = Random().nextInt(101)
        while (random1 == random2) {
            random2 = Random().nextInt(101)
        }
        btnLeft.text = random1.toString()
        btnRight.text = random2.toString()
    }
}