package com.example.dh.ui.favorites

import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.dh.model.Data
import com.example.dh.network.RealmService

class FavoritesViewModel : ViewModel() {
    val favs = MutableLiveData<List<Data>>()
    var favsList = mutableListOf<Data>()
    fun  getNewsListObserver(): MutableLiveData<List<Data>> {
        return favs;
    }
    init {
        favsList.addAll(RealmService.getAllData())
        favs.postValue(favsList)

    }
}