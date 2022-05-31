package com.abulnes16.tempo_native.services

import android.util.Log
import com.abulnes16.tempo_native.helpers.UrlBuilder
import com.abulnes16.tempo_native.models.Forecast
import com.abulnes16.tempo_native.models.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val weatherService = retrofitInstance.create(WeatherApi::class.java)
}