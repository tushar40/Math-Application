package com.example.mathapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.Window
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mathapplication.databinding.ActivityComputeBinding
import com.example.mathapplication.viewmodels.ComputeViewModel

class ComputeActivity: AppCompatActivity() {

    companion object {
        val RESULT_KEY = "result_key"
    }

    /**
     * Property Variables
     */

    private val computeViewModel: ComputeViewModel by viewModels()

    /**
     * Lifecycle Methods
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = Fade()
            exitTransition = Fade()
        }

        val binding = ActivityComputeBinding.inflate(layoutInflater)
        binding.computeViewModel = computeViewModel

        val view = binding.root
        setContentView(view)

        setUpUI(binding)
    }

    override fun onStart() {
        super.onStart()

        addObservers()
    }

    override fun onStop() {
        super.onStop()

        removeObservers()
    }

    /**
     * Custom Methods
     */

    private fun setUpUI(binding: ActivityComputeBinding) {
        binding.buttonAdd.setOnClickListener {
            computeViewModel.add()
        }

        binding.buttonSubtract.setOnClickListener {
            computeViewModel.subtract()
        }
    }

    private fun addObservers() {
        computeViewModel.errorString.observe(this, Observer { event ->
            val errorString = event.getContentIfNotHandledOrReturnNull()
            if (errorString != null)
                Toast.makeText(applicationContext, "Error: $errorString", Toast.LENGTH_SHORT).show()
        })

        computeViewModel.resultComputed.observe(this, Observer { event ->
            val success = event.getContentIfNotHandledOrReturnNull()
            if (success == true) {
                gotoResultActivity()
            }
        })
    }

    private fun removeObservers() {
        computeViewModel.errorString.removeObservers(this)
        computeViewModel.resultComputed.removeObservers(this)
    }

    private fun gotoResultActivity() {
        try {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(RESULT_KEY, computeViewModel.result.get())
            startActivity(intent)
            computeViewModel.reset()
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Error going to Result activity", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}