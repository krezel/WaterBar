package com.example.waterbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar? = findViewById(R.id.water_bar)
        val waterInput: EditText = findViewById(R.id.water_ml)
        val btnSave: Button = findViewById(R.id.zapisz_wode)
        btnSave.setOnClickListener {
            try {
                if ((1..2000).contains(waterInput.text.toString().toInt()))
                    progressBar?.incrementProgressBy(waterInput.text.toString().toInt())
                else
                    progressBar?.incrementProgressBy(0)
            }catch (e: java.lang.NumberFormatException){
                progressBar?.incrementProgressBy(0)
            }
            if(progressBar?.progress==progressBar?.max)
                progressBar?.progress = 0
        }
    }
}