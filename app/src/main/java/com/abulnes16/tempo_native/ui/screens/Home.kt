package com.abulnes16.tempo_native.ui.screens

import ForecastList
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.models.*
import com.abulnes16.tempo_native.ui.components.atoms.Logo
import com.abulnes16.tempo_native.ui.components.molecules.ErrorMessage
import com.abulnes16.tempo_native.ui.components.molecules.SearchWeather
import com.abulnes16.tempo_native.ui.components.organisms.WeatherSection
import com.abulnes16.tempo_native.ui.theme.Secondary
import com.abulnes16.tempo_native.viewmodels.TempoViewModel

@Composable
fun Home(viewModel: TempoViewModel) {

    with(viewModel) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .fillMaxWidth(1f)
        ) {
            Logo()
            SearchWeather(
                onPress = { city -> getWeather(city) },
            )
            when (fetchState) {
                FetchState.SUCCESS -> {
                    WeatherSection(weather = weather!!)
                    ForecastList(forecast = forecast!!)
                }
                FetchState.LOADING -> {
                    CircularProgressIndicator(color = Secondary)
                }
                FetchState.ERROR -> {
                    ErrorMessage()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home(viewModel = TempoViewModel())
}