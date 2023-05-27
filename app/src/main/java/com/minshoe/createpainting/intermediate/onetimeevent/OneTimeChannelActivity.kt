package com.minshoe.createpainting.intermediate.onetimeevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import com.minshoe.createpainting.R
import com.minshoe.createpainting.databinding.ActivityOneTimeChannelBinding

class OneTimeChannelActivity : AppCompatActivity() {


    private lateinit var viewModel: OneTimeChannelViewModel

    private lateinit var binding: ActivityOneTimeChannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_one_time_channel)
        binding = ActivityOneTimeChannelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(OneTimeChannelViewModel::class.java)

        binding.btnShowSnackbar.setOnClickListener {
            viewModel.triggerEvent()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect { event ->
                when (event) {
                    is OneTimeChannelViewModel.MyEvent.ErrorEvent -> {
                        Snackbar.make(binding.root, event.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }

    }
}