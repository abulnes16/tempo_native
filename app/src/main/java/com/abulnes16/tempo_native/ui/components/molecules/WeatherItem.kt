package com.abulnes16.tempo_native.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.models.Weather
import com.abulnes16.tempo_native.ui.theme.Alternative
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Secondary
import com.abulnes16.tempo_native.ui.theme.Typography

@Composable
fun WeatherItem(weather: Weather) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .background(Color.White),
        elevation = 3.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_wb_sunny),
                    contentDescription = null,
                    tint = Secondary,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                Text(
                    text = "${weather.temperature} °C",
                    style = Typography.h2
                )
                Text(
                    text = "${weather.city} ${weather.country}",
                    style = Typography.h3
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_water),
                        contentDescription = null,
                        modifier = Modifier
                            .width(10.dp)
                            .height(10.dp),
                        tint = Primary
                    )
                    Text(
                        text = "Humidity ${weather.humidity}%",
                        style = Typography.body2,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_air),
                        contentDescription = null,
                        modifier = Modifier
                            .width(10.dp)
                            .height(10.dp),
                        tint = Alternative

                    )
                    Text(
                        text = "Wind ${weather.wind} m/s",
                        style = Typography.body2,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherItemPreview() {
    WeatherItem(
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