package com.example.weatherappmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.weatherappmvvm.network.model.Location
import com.example.weatherappmvvm.repository.SearchActivityRepository


class SearchActivityViewModel(application: Application) : AndroidViewModel(application){
    private val repository = SearchActivityRepository(application)
    val showProgress : LiveData<Boolean>
    val locationList : LiveData<List<Location>>

    init {
        this.showProgress = repository.showProgress
        this.locationList = repository.locationList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchLocation(searchString: String){
        repository.searchLocation(searchString)
    }
}