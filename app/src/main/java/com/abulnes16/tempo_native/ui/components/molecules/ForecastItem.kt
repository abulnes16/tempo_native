package com.abulnes16.tempo_native.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Typography

@Composable
fun ForecastItem() {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_air),
                contentDescription = null,
                tint = Primary
            )
            Text(text = "Lu")
            Text(text = "25 °C", style = Typography.h4)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastItemPreview() {
    ForecastItem()
}