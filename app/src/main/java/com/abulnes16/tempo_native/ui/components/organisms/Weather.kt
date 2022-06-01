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
import androidx.compose.ui.res.stringResource
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.models.Coordinates
import com.abulnes16.tempo_native.models.Wind

@Composable
fun WeatherSection(weather: Weather) {
    Column(modifier = Modifier.padding(10.dp)) {
        Title(title = stringResource(id = R.string.current_weather))
        WeatherItem(weather = weather)
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherSection(
        Weather(
            weatherType = 0,
            temperature = 19.0,
            city = "Tegucigalpa",
            country = "HN",
            humidity = 77.0,
            wind = 2.06
            )
    )
}