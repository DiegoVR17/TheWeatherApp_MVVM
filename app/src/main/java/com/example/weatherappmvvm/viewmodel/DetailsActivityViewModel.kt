package com.example.weatherappmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherappmvvm.network.model.WeatherResponse
import com.example.weatherappmvvm.repository.DetailsActivityRepository

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application){

    private val repository = DetailsActivityRepository(application)
    val showProgress : LiveData<Boolean>
    val response : LiveData<WeatherResponse>

    init {
        showProgress = repository.showProgress
        response = repository.response
    }

    fun getWeather(woeId: Int){
        repository.getWeather(woeId)
    }
}