package com.example.testingapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testingmodule.DemoFile

class MainActivity : AppCompatActivity() {
    private val viewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DemoFile()


        val textView = findViewById<TextView>(R.id.textCounter)
        val btnIncrement = findViewById<Button>(R.id.buttonIncrement)

        viewModel.counter.observe(this) {
            textView.text = it?.value?.toString() ?: "0"
        }

        btnIncrement.setOnClickListener {
            val current = viewModel.counter.value?.value ?: 0
            viewModel.incrementCounter(current)
        }
    }
}