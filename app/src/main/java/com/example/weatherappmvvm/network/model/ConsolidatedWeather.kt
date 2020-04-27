package com.example.weatherappmvvm.network.model


import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("id")
    val id: Long,
    @SerializedName("the_temp")
    val theTemp: Double
)