package ru.gb.student.gb_popular_lib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.gb.student.gb_popular_lib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.refreshButton.setOnClickListener{
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }
    }
}