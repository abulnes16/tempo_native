package com.abulnes16.tempo_native.services


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val weatherService = retrofitInstance.create(WeatherApi::class.java)
}