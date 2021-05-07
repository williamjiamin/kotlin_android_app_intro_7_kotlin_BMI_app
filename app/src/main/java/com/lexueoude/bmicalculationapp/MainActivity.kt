package com.lexueoude.bmicalculationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lexueoude.bmicalculationapp.databinding.ActivityMainBinding


//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculateBMIButton.setOnClickListener {
            val weight = binding.weightEditText.text.toString().toFloat()
            val height = binding.heightEditText.text.toString().toFloat()

            val BMI = weight / (height * height * 0.0001)

            val str: String = String.format("您的BMI为%.2f", BMI)
            binding.BMITextView.text = str

            if (BMI < 18.5) {
                binding.BMIImageView.setImageResource(R.drawable.underweight)
            } else if (BMI >= 18.5 && BMI < 23.9) {
                binding.BMIImageView.setImageResource(R.drawable.healthy)
            } else if (BMI >= 23.9 && BMI < 27.9) {
                binding.BMIImageView.setImageResource(R.drawable.overweight)
            } else if (BMI >= 27.9) {
                binding.BMIImageView.setImageResource(R.drawable.obesity)
            } else {
                Toast.makeText(this, "请输入身高与体重信息！", Toast.LENGTH_SHORT).show()
            }


        }

    }
}