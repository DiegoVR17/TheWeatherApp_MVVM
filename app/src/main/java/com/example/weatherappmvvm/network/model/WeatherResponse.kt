package com.example.weatherappmvvm.network.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ConsolidatedWeather>,
    @SerializedName("time")
    val time: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)