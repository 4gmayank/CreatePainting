package com.minshoe.createpainting.basic.flows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.minshoe.createpainting.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


/**
 * Reactive Programming
 * RxJava
 * Coroutines With Flow
 *
 * Flow is coroutine that can emit multiple values sequentially
 * Flow can emit a stream of data. A Stream of Multiple values over a period of time.
 *
 * kotlin-coroutine-android
 *
 * What is stateFlow
 */

class BasicFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_flow)


        /// Kotlin flow producer-Consumer Design Patter
        val myFlow = flow<Int>{
            for (i in 1..100){
                emit(i)/// PRODUCERS

                delay(1000L)

            }
        }
        val textView = findViewById<TextView>(R.id.flowId)

        ///Simple task main thread can handle no need BG
        CoroutineScope(Dispatchers.Main).launch {
            myFlow.collect{
                ///CONSUMER
                Log.i("MYTAG", "Current Inted is $it")
                textView.setText("Current Inted is $it")
            }
        }

    }




    fun getTotal(): Int{
        return 56
    }
    fun getTotalFlow(): Int{
        return 56
    }
}