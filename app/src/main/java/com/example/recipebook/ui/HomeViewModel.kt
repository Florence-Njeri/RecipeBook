package com.example.recipebook.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipebook.data.Module

class HomeViewModel : ViewModel() {
    // TODO: Implement the
    //LiveData for navigation
    private val _navigateToModuleDetails = MutableLiveData<Module>()
    val navigateToModuleDetails: LiveData<Module>
        get() = _navigateToModuleDetails

    /** Handle RecyclerViewClicks**/
    fun onNewsItemClicked(modules: Module) {

//        _navigateToModuleDetails.value = news

    }
}
