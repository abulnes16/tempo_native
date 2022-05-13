package com.abulnes16.tempo_native.ui.components.organisms


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.models.Weather
import com.abulnes16.tempo_native.ui.components.atoms.Title
import com.abulnes16.tempo_native.ui.components.molecules.WeatherItem
import androidx.compose.ui.Modifier

@Composable
fun Weather(weather: Weather) {
    Column(modifier = Modifier.padding(10.dp)) {
        Title(title = "Current weather")
        WeatherItem(weather = weather)
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    Weather(
        Weather(
            weatherType = "Sunny",
            temperature = "19",
            city = "Tegucigalpa",
            country = "HN",
            humidity = "77",
            wind = "2.06"
        )
    )
}