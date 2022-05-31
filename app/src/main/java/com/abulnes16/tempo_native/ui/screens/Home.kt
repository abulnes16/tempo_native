package com.abulnes16.tempo_native.ui.screens

import ForecastList
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.models.*
import com.abulnes16.tempo_native.services.Api
import com.abulnes16.tempo_native.ui.components.Logo
import com.abulnes16.tempo_native.ui.components.molecules.SearchWeather
import com.abulnes16.tempo_native.ui.components.organisms.WeatherSection
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Secondary
import com.abulnes16.tempo_native.viewmodels.TempoViewModel

@Composable
fun Home(viewModel: TempoViewModel) {

    var cityName by remember { mutableStateOf("") }


    with(viewModel) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)
        ) {
            Logo()
            SearchWeather(
                cityName,
                onPress = { getWeather(cityName) },
                onChange = { city -> cityName = city })
            if (fetchState == FetchState.SUCCESS) {
                WeatherSection(weather = weather!!)
                ForecastList(forecast = forecast!!)
            } else if (fetchState == FetchState.LOADING) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(color = Secondary)
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val dummyWeather = Weather(
        weatherType = 0,
        temperature = 19.0,
        city = "Tegucigalpa",
        country = "HN",
        humidity = 77.0,
        wind = 2.06
    )
    val dummyForecast = listOf<Forecast>(
        Forecast(0, "Lu", "25"),
        Forecast(0, "Ma", "29"),
        Forecast(0, "Mi", "20"),
        Forecast(0, "Ju", "30")
    )
    Home(viewModel = TempoViewModel())
}