package ru.psu.kotlin_android_2024_mobile.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.psu.kotlin_android_2024_mobile.databinding.ActivityCalculatorBinding

class CActivityCalculatorView : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        setContentView(R.layout.activity_main)

//        enableEdgeToEdge()
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        //val button = findViewById<Button>(R.id.button)
        binding.buttonPlus.setOnClickListener {
            binding.value1.editText?.text.toString().toDoubleOrNull()?.let{v1->
                binding.value2.editText?.text.toString().toDoubleOrNull()?.let{v2->
                    binding.textViewResult.editText?.setText("${v1+v2}")
                }
            }
            //val txt = binding.textInputLayout.editText?.text ?: "ggggg"
            //binding.textView.
            //text = "133txt"



//            Toast.makeText(this, "ПРивет!", Toast.LENGTH_LONG).show()
        }

//        binding.imageView1.setOnClickListener {
//            Toast.makeText(this, "Это сердце!", Toast.LENGTH_LONG).show()
//        }
    }
//    fun obButton123aClick(
//        view : View
//    )
//    {
//        Toast.makeText(this, "Привет!", Toast.LENGTH_LONG).show()
//    }


}