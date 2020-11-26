package com.example.mathapplication.activities

import android.os.Bundle
import android.transition.Explode
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mathapplication.databinding.ActivityResultBinding
import com.example.mathapplication.viewmodels.ResultViewModel

class ResultActivity: AppCompatActivity() {

    /**
     * Property Variables
     */

    private val resultViewModel: ResultViewModel by viewModels()

    /**
     * Lifecycle Methods
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = Explode()
            exitTransition = Explode()
        }

        val binding = ActivityResultBinding.inflate(layoutInflater)
        binding.resultViewModel = resultViewModel

        val view = binding.root
        setContentView(view)

        resultViewModel.result.set(intent.extras?.get(ComputeActivity.RESULT_KEY) as String?)
    }

}