package org.hyperskill.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.hyperskill.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel: CalculatorViewModel by viewModels()
        val listener = View.OnClickListener { v -> viewModel.digitPressed((v as Button).text.toString()) }

        viewModel.getResult.observe(this, { result -> binding.editText.setText(result) })

        setListener(binding.button1, listener)
        setListener(binding.button2, listener)
        setListener(binding.button3, listener)
        setListener(binding.button4, listener)
        setListener(binding.button5, listener)
        setListener(binding.button6, listener)
        setListener(binding.button7, listener)
        setListener(binding.button8, listener)
        setListener(binding.button9, listener)

        binding.button0.setOnClickListener { viewModel.zeroPressed() }
        binding.dotButton.setOnClickListener { viewModel.dotPressed() }
        binding.clearButton.setOnClickListener { viewModel.clearPressed() }
    }

    private fun setListener(button: Button, listener: View.OnClickListener) = button.setOnClickListener(listener)
}