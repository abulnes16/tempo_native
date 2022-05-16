package com.abulnes16.tempo_native.ui.screens

import ForecastList
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.models.Forecast
import com.abulnes16.tempo_native.models.Weather
import com.abulnes16.tempo_native.ui.components.Logo
import com.abulnes16.tempo_native.ui.components.molecules.SearchWeather
import com.abulnes16.tempo_native.ui.components.organisms.WeatherSection

@Composable
fun Home() {

    var cityName by remember { mutableStateOf("") }

    val dummyWeather = Weather(
        weatherType = "Sunny",
        temperature = "19",
        city = "Tegucigalpa",
        country = "HN",
        humidity = "77",
        wind = "2.06"
    )
    val dummyForecast = listOf<Forecast>(
        Forecast("Wind", "Lu", "25"),
        Forecast("Wind", "Ma", "29"),
        Forecast("Wind", "Mi", "20"),
        Forecast("Wind", "Ju", "30"),
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Logo()
        SearchWeather(cityName) { city -> cityName = city }
        WeatherSection(weather = dummyWeather)
        ForecastList(forecast = dummyForecast)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}