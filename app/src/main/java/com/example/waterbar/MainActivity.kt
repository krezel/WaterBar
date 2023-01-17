package com.example.waterbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar? = findViewById(R.id.water_bar)
        val waterInput: EditText = findViewById(R.id.water_ml)
        val btnSave: Button = findViewById(R.id.zapisz_wode)
        val waterCounter: TextView = findViewById(R.id.water_counter)
        var waterQuan = 0
        btnSave.setOnClickListener {
            try {
                if ((1..2000).contains(waterInput.text.toString().toInt())){
                    progressBar?.incrementProgressBy(waterInput.text.toString().toInt())
                waterQuan += waterInput.text.toString().toInt()
                    if(waterQuan>1999)
                        waterQuan=0
                }
                else
                    progressBar?.incrementProgressBy(0)
            }catch (e: java.lang.NumberFormatException){
                progressBar?.incrementProgressBy(0)
            }
            val string = String.format("$waterQuan/2000")
            waterCounter.text = string
            if(progressBar?.progress==progressBar?.max)
                progressBar?.progress = 0
        }
    }
}