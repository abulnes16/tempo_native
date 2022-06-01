package com.abulnes16.tempo_native.helpers


import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.models.*
import com.abulnes16.tempo_native.ui.theme.Alternative
import com.abulnes16.tempo_native.ui.theme.Gray
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Secondary
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
            val weatherType = getWeatherType(this.weather[0].main)
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
            val weatherType = getWeatherType(this.weather[0].main)
            val day = getWeekOfDay(this.dt)
            val temperature = convertTemperature(this.temp.day)
            return Forecast(
                weatherType = weatherType,
                day = day,
                temperature = temperature.toString()
            )
        }
    }

    private fun convertTemperature(temp: Double): Double {
        return floor(temp - 273.15)
    }

    private fun getWeatherType(weatherType: String): WeatherType {

        val weatherIcon = when (weatherType) {
            WeatherTypes.Sun.weatherName -> R.drawable.ic_baseline_wb_sunny
            WeatherTypes.Clouds.weatherName -> R.drawable.ic_baseline_wb_cloudy
            WeatherTypes.Drizzle.weatherName -> R.drawable.ic_baseline_waves
            WeatherTypes.Rain.weatherName -> R.drawable.ic_baseline_water
            WeatherTypes.Snow.weatherName -> R.drawable.ic_baseline_snow
            WeatherTypes.Thunderstorm.weatherName -> R.drawable.ic_baseline_wb_cloudy
            else -> R.drawable.ic_baseline_air
        }

        val weatherColor = when (weatherType) {
            WeatherTypes.Sun.weatherName -> Primary

            WeatherTypes.Thunderstorm.weatherName,
            WeatherTypes.Clouds.weatherName -> Gray
            WeatherTypes.Snow.weatherName,
            WeatherTypes.Rain.weatherName,
            WeatherTypes.Drizzle.weatherName -> Alternative
            else -> Secondary

        }

        return WeatherType(weatherIcon = weatherIcon, weatherColor = weatherColor)
    }

    private fun getWeekOfDay(date: Long): String {
        val dateObj = Date(date * 1000)
        return SimpleDateFormat("E", Locale.ENGLISH).format(dateObj)
            .replaceFirstChar { it.uppercase() }
    }

}