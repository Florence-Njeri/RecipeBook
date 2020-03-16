package com.example.recipebook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipebook.data.Notifications

class MainActivityViewModel(): ViewModel() {
    private var _notificationsItem = MutableLiveData<Notifications>()
    val selectedItem: LiveData<Notifications>
        get() = _notificationsItem

    init {
//        _notificationsItem.value = news
        Log.i("SelectedItem", _notificationsItem.value.toString())
    }
}