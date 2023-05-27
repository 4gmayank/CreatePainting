package com.minshoe.createpainting.basic.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minshoe.createpainting.R

/**
 * BG Task Management System
 * It is deferrable by work manager
 * capable of being post ponded background works
 *
 * It is surePass that the system will run the postponded task
 * (even if app closed)
 *
 * Work manager manage the logic to start the work under situations:
 * 1. forground, bac
 *
 * TA. Periodic Work Request
 * TB. One Time Work Request
 * Schedule via
 * 1. Create a Worker Class
 * 2. Create Work Request
 * 3. Enqueue the request
 * 4. Get the Status updates
 *
 *
 * + Mange Scheduler
 * + take care of constraines
 * - need task
 *
 * Feat
 * 1. Chaining Tasks
 * 2. Status Updates
 * 3. Constraints
 * 4. Minimum Resource Usage
 * 5. Support Version
 * 6. Async and Periodic Task support
 *
 * X for bg thread task
 * Y: Need to survive process death
 *
 * {Problem}: Periodic Work Request
 * App for sales team, Each sales man need to see current stock count of products
 * Regular update from Main Server
 *
 * One-Time Work Request
 * An appropriate time: with availability of Internet and battery charge level
 *
 *
 * Alternative: complex and time consuming
 * 1. Firebase JobDispatcher,(if task uses firebase)
 * 2. JobScheduler,(23+)
 * 3. Alarm Manager with B.R to schedule task(22)
 *
 * $work-time-ktx
 *
 *
 */


class BasicWorkMangerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_work_manger)
    }
}