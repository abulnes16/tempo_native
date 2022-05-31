package com.abulnes16.tempo_native.helpers

import android.util.Log
import androidx.compose.ui.text.capitalize
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.models.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor

object Mapper {

   fun getWeatherInfo(weather: WeatherResponse): Weather {
        with(weather) {
            val temperature = convertTemperature(this.main.temp)
            val name = this.name
            val country = this.sys.country
            val humidity = this.main.humidity
            val wind = this.wind.speed
            val weatherType = getWeatherType(this.weather[0].main ?: WeatherTypes.SUN)
            return Weather(
                city = name,
                country = country,
                humidity = humidity,
                temperature = temperature,
                wind = wind,
                weatherType = weatherType
            )
        }
    }

    fun getForecastInfo(forecast: DailyForecast): Forecast {
        with(forecast) {
            val weatherType = getWeatherType(this.weather[0].main ?: WeatherTypes.SUN)
            val day = getWeekOfDay(this.dt)
            Log.d("[Day converstion]", day.toString())
            val temperature = convertTemperature(this.temp.day)
            return Forecast(
                weatherType = weatherType,
                day = day.toString(),
                temperature = temperature.toString()
            )
        }
    }

    private fun convertTemperature(temp: Double): Double {
        return floor(temp - 273.15)
    }

    private fun getWeatherType(weatherType: WeatherTypes): Int {
        return when (weatherType) {
            WeatherTypes.SUN -> R.drawable.ic_baseline_wb_sunny
            WeatherTypes.CLOUDS -> R.drawable.ic_baseline_wb_cloudy
            WeatherTypes.DRIZZLE -> R.drawable.ic_baseline_waves
            WeatherTypes.RAIN -> R.drawable.ic_baseline_water
            WeatherTypes.SNOW -> R.drawable.ic_baseline_snow
            else -> R.drawable.ic_baseline_air
        }
    }

    private fun getWeekOfDay(date: Long): String {
        val dateObj = Date(date * 1000)
        return SimpleDateFormat("E").format(dateObj).replaceFirstChar { it.uppercase() }
    }

}