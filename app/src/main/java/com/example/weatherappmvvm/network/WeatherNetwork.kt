package com.example.weatherappmvvm.network

import android.location.Location
import com.example.weatherappmvvm.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://www.metaweather.com/api/location/"
interface WeatherNetwork {

    @GET("search?")
    fun getLocation(@Query("query")searchString: String) : Call<List<com.example.weatherappmvvm.network.model.Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid") woeid: Int) : Call<WeatherResponse>
}