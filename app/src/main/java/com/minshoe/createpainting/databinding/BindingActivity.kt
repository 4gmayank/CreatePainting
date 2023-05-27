package com.minshoe.createpainting.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.minshoe.createpainting.R

/**
 * 1. ViewBinding{1}: light weight, binds view to code
 *
 * 2. DataBinding{2}
 */

class BindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding);
        val button: Button = findViewById<Button>(R.id.bindingButton);
        ///binding.submitButton
        button.setOnClickListener {
            displayGreeting()
        }

    }

    /**
     *   FindViewById function to obtain references, to views
     *  everytime we use the method, to get reference to view
     *  Android Studio have to go through view heirachy and find it at RUN-TIME
     *  large app have 100s of view and 100s of layout
     *  Reducing performance
     */

    /**
     * Create binding object that contains the reference to each view, for layout
     * once binding object is created. All the component of app. access the views and other data through binding object
     * Android system do not go to view heirachy.
     * Improves the performance of the ap
     * + Read + Maintain, Conscise.
     * + Compile Time Checking
     */

    /**
     * Enable Data Binding
     * dataBinding{enabled = true}
     * Wrap XML with layout tags
     * Wrap layout with <layout>
     * Construct a data binding object
     * DataBinding library will create ActivityMainBinding class for referecnce for activity_main layout
     *
     *
     *
     *
     * Drawbacks
     * https://medium.com/androiddevelopers/data-binding-lessons-learnt-4fd16576b719
     * Mainting issue
     * increase in Coupling and reduces cohesion
     * Instrumentation for test
     *
     *
     */
    private fun displayGreeting() {

        ///Apply Scoping Function
        binding.apply {
            ///Use of apply to set lot of view
            greetingTextView.text = "Hello " + "Sir"
        }
        val messageView: TextView = findViewById(R.id.greetingTextView)
        val nameText: EditText = findViewById(R.id.nameEditText)


        messageView.text = "Hello " + nameText.text

    }

}


/**
 * Misc:
 * Kotlin Syntetic(extenstions)
 * directly call views using their ids///2021last
 */

/**
 * Jetpack compse:
 * high level: Kotlin multiplatform
 *
 */