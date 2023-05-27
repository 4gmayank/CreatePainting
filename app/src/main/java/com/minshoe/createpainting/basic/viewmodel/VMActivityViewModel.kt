package com.minshoe.createpainting.basic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class VMActivityViewModel : AndroidViewModel() {
// It will have instance of application as constructor parameter.
/// application context for code of ViewModel
/// V: ViewModel vs AndroidViewModel
/**
 * AndroidVM are context aware, when inflating we need to pass aplicationContext as a parameter
 * Use ViewModelProvider Utility to provide the instance to activity
 *
 */


/// Info : AndroidViewModel
//class VMActivityViewModel : ViewModel() {
class VMActivityViewModel(startingTotal: Int) : ViewModel() {


    private var count = 0;

    init {
        count = startingTotal
    }

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdatedCount(): Int {
        return ++count;
    }

    ///CustomViewModel: we neeed support from ViewModelFactory Class


    /**
     * C. With LiveData
     * Automatically update the UI
     * A lifecycle aware observable data holder class
     * + Acitvity
     * + Framgents
     * + Services
     * can be used observers as live data
     * live data only updates the observes in an active lifecycle state
     * In RxJava , we have to carefully dispose the observers, when activity/frag/service becomes inactive
     *
     * - managing UI
     * - no need to handle lifecycle,
     * - No crashes
     * - no memory leaks
     * + share app service our app service bw different component of app
     */

    private var _total = MutableLiveData<Int>()
    private var _name = MutableLiveData<String>()

    /**
     * Data in a LiveData object are only readable, not editable
     * Mutable lets us to change/update
     */
    init {
        _total.value = startingTotal
    }

    fun getTotal(): MutableLiveData<Int> {
        return _total
    }

    fun getName(): MutableLiveData<String>{
        return _name
    }

    fun setName(input: String){
         _name.value = input
    }


    fun setTotal(input: Int) {
        _total.value = (_total.value)?.plus(input)
    }


}