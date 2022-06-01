package com.abulnes16.tempo_native.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abulnes16.tempo_native.helpers.Mapper
import com.abulnes16.tempo_native.helpers.UrlBuilder
import com.abulnes16.tempo_native.models.FetchState
import com.abulnes16.tempo_native.models.Forecast
import com.abulnes16.tempo_native.models.Weather
import com.abulnes16.tempo_native.services.Api
import kotlinx.coroutines.launch

class TempoViewModel : ViewModel() {
    var weather: Weather? by mutableStateOf(null)
    var forecast: List<Forecast>? by mutableStateOf(listOf())
    var fetchState: FetchState by mutableStateOf(FetchState.SUCCESS)


    fun getWeather(cityName: String? = "tegucigalpa") {
        fetchState = FetchState.LOADING
        viewModelScope.launch {
            try {
                val query = UrlBuilder.createWeatherUrl("weather", "q=${cityName ?: "tegucigalpa"}")
                val response = Api.weatherService.getWeather("${Api.BASE_URL}${query}")
                Log.d("[GET WEATHER]:", response.toString())
                if (response.isSuccessful) {
                    val body = response.body()
                    val coords = body?.coord
                    getForecast(coords?.lat!!, coords.lon)
                    weather = Mapper.getWeatherInfo(body)
                } else {
                    throw  Exception("Failed to fetch weather")
                }
            } catch (e: Exception) {
                Log.e("[GET WEATHER EXCEPTION]", e.toString())
                fetchState = FetchState.ERROR
            }
        }
    }

    private fun getForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                val query = UrlBuilder.createWeatherUrl(
                    "onecall",
                    "lat=${lat}&lon=${lon}&exclude=hourly,minutely"
                )
                val response = Api.weatherService.getForecast("${Api.BASE_URL}${query}")
                if (response.isSuccessful) {
                    val body = response.body()
                    forecast = body?.daily?.map { forecast -> Mapper.getForecastInfo(forecast) }
                    fetchState = FetchState.SUCCESS
                } else {
                    throw Exception("Failed to fetch forecast")
                }
            } catch (e: Exception) {
                Log.e("[FORECAST EXCEPTION]", e.toString())
                fetchState = FetchState.ERROR
            }

        }

    }
}