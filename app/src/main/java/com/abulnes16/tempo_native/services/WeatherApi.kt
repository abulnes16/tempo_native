package com.abulnes16.tempo_native.services


import com.abulnes16.tempo_native.models.ForecastResponse
import com.abulnes16.tempo_native.models.WeatherResponse
import retrofit2.Response

import retrofit2.http.GET

import retrofit2.http.Url

interface WeatherApi {
    @GET
    suspend fun getWeather(@Url url: String): Response<WeatherResponse>

    @GET
    suspend fun getForecast(@Url url: String): Response<ForecastResponse>
}