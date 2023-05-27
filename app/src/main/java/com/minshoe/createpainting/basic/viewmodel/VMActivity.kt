package com.minshoe.createpainting.basic.viewmodel

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.minshoe.createpainting.R
import com.minshoe.createpainting.databinding.ActivityVmBinding

//class VMActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

class VMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVmBinding
    private var count = 0

    private lateinit var viewModel: VMActivityViewModel
    private lateinit var viewModelFactory: VMCustomViewModelFactory

    /**
     * # Model for a View: Design to store and manage UI related data.
     * Multiple Activity/Fragment can share view model.
     * View model leaves when component is cleared
     * CSR PSD f() onCleared
     *
     * wh
     *
     * Problem
     * 1. Enable data binding
     * 2. Rotation of Device Recreate the activity
     * 3. Configuration Changes: Screen Rotation, Keyboard, Changes, Language Changes, Enabling MultiWindow Mode
     * //2000 products will downloaded again and again from rest api by system resources,
     * // User Experience -ve : wait
     * https://developer.android.com/jetpack
     * Cofnfiguration changes , app has to destroy and recreates the activity  or fragment. with new configurations
     * by VM we can keep and reterive object vlaue(states) of the activity
     *
     *
     * 4.
     *
     *
     * Solution
     * 1. Add dependency
     * 1. Extend Class with ViewModel/AndroidViewModel to sto store and manage Data
     * 2. init the class parameter by ViewModelProvider(this,).get(VMActivityViewModel::class.java)
     * 3. viewModel.onCleared() call when no longer req
     * 4. invoke it when (debug::Info) if it is called on closing activity
     *
     * Additional: viewModel: VMActivityViewModel by viewModels() //Unstable
     *
     * Problem 2
     * Can we quick this with liveData
     * CustomViewModel
     * we use ViewModelFactory when we need to use customViewModel with constructor parameters
     * 1. Create fac:ViewModelProvider.Factory
     * 2. define its onCreate and send construtor parameter
     * 3. init the factory in Actory, and pass it ViewModelProvider(it, fac)
     *
     */


    // it dont run with this
    //    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vm)
        viewModelFactory = VMCustomViewModelFactory(125)


        viewModel = ViewModelProvider(this, viewModelFactory).get(VMActivityViewModel::class.java)
//        viewModel = ViewModelProvider(this,).get(VMActivityViewModel::class.java)


//        binding.vmCountText.text = count.toString();
//        binding.vmClickBtn.setOnClickListener {
//            count++
//            binding.vmCountText.text = count.toString()
//        }

//      #2  Integrate it with view model
//        binding.vmCountText.text = viewModel.getCurrentCount().toString();
//        binding.vmClickBtn.setOnClickListener {
//            viewModel.getUpdatedCount()
//            binding.vmCountText.text = viewModel.getCurrentCount().toString()
//        }

//        #3 Integrate it with live data
//        viewModel.getTotal().observe(this, Observer {
//            binding.vmCountText.text = it.toString()
//        })
//
//
//        binding.vmClickBtn.setOnClickListener {
//            viewModel.setTotal(+1)
//        }

//        #4 Adding Data binding to above
        /**
         * We will use listener binding for button to invoke update
         *
         *
         **/
//        viewModel.getTotal().observe(this, Observer {
//            binding.vmCountText.text = it.toString()
//        })
//        binding.viewModel = viewModel
//        #5. INtegrate live data with data binding
        /**
         *
         * Live data always associated with lifecycle of activyt/fragment/service
         * provide actual owner of the data binding object
         */
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


//        # Two way Data binding
        /**
         * change values associated object
         * values of UI changes -> object changes
         * object changes -> values changes
         *
          */



    }


}