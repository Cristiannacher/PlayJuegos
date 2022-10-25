package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar

class PreferenciesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencies)

        val rg: RadioGroup = findViewById(R.id.radioGroup) as RadioGroup
        val rb = findViewById(R.id.ratingBar1) as RatingBar
        val sb: SeekBar = findViewById(R.id.seekBar)
        var option: String
        var checked: Boolean


        rg.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val checkedRadioButton = group.findViewById<RadioButton>(checkedId)
                option = checkedRadioButton.text.toString()
                checked = true
            }
        })


        rb.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                sb.progress = rating.toInt()
            }

        sb.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean){
                rb.rating = progress.toFloat()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


    }
}