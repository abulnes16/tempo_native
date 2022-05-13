package com.abulnes16.tempo_native.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Secondary

@Composable
fun WeatherItem() {
    Card() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny),
                contentDescription = null,
                tint = Secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherItemPreview() {
    WeatherItem()
}