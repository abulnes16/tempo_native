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

    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val weatherService = retrofitInstance.create(WeatherApi::class.java)

    fun getWeather(cityName: String? = "tegucigalpa") {
        CoroutineScope(Dispatchers.IO).launch {
            val query = UrlBuilder.createWeatherUrl("weather", "q=${cityName ?: "tegucigalpa"}")
            val response = weatherService.getWeather("${BASE_URL}${query}")
            Log.d("[GET WEATHER]:", response.toString())
            if (response.isSuccessful) {
                // TODO: Call forecast
                val body = response.body()
                val coords = body?.coord
                getForecast(coords?.lat!!, coords?.lon!!)
            } else {
                // TODO: Update error state and show error on app
            }
        }
    }

    fun getForecast(lat: Double, lon: Double) {
        CoroutineScope(Dispatchers.IO).launch {
            val query = UrlBuilder.createWeatherUrl("onecall","lat=${lat}&lon=${lon}&exclude=hourly,minutely")
            val response = weatherService.getForecast("${BASE_URL}${query}")
            Log.d("[GET FORECAST]:", response.toString())
            if (response.isSuccessful) {
                // TODO: Hide loader
                val body = response.body()
                Log.d("[FORECAST BODY]", body.toString())
            } else {
                // TODO: Show error
            }
        }
    }

}