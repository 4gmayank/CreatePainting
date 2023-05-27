package com.minshoe.createpainting.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.minshoe.createpainting.R

class BindingObjectActivity : AppCompatActivity() {

    private lateinit var binding: BindingObjectActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_binding)
        binding = DataBindingUtil.setContentView(this, R.layout.binding_object_activity);
        val button: Button = findViewById<Button>(R.id.bindingButton);


        setSudent();


//        val student: Student = getStudent()
//        binding.emailTextView.text = student.email
//        binding.greetingTextView.text = student.name

    }

    /**
     * Whenever we update the layout>data>variable: with the object
     * binding.variable =
     * It will udpate the whole layout
     * @{student.name}
     */
    private fun setSudent() {
        binding.student = getStudent()
    }

    private fun getStudent(): Student {
        return Student(1, "Alex", "alex@gmail.com");

    }
}

data class Student(
    var id: Int,
    var name: String,
    var email: String
)