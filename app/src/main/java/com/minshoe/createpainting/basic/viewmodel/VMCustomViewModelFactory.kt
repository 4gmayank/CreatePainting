package com.minshoe.createpainting.basic.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

//class VMActivityViewModel : AndroidViewModel() {
// It will have instance of application as constructor parameter.
/// application context for code of ViewModel
/// V: ViewModel vs AndroidViewModel


/// Info : AndroidViewModel
class VMCustomViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {

    /**
     * CustomViewModel: we neeed support from ViewModelFactory Class
     * We need to define variable in factory class
     */


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VMActivityViewModel::class.java)) {
            return VMActivityViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")


//        return super.create(modelClass)
    }

}