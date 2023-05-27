package com.minshoe.createpainting.basic.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minshoe.createpainting.R


/**
 * Android Navigation Jetpack ARchitecture
 * Built-In
 *
 * New Trend: Single Activity: Mutliple Framgments
 * it genearates lot of support classes
 * 1. Navigation Graph: xml res file: navigation related info, manages navigation related task
 * 2. NavHostFragment: empty container, on Activity, holds Navigation Graph
 * 3. NavController: class generated , to manage navigation bw destiantaions.
 *
 * - Add library
 * - to pass data b/w fragments
 * use safeArgs add library
 */


/**
 *
 */
class BasicNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_nav)
    }
}