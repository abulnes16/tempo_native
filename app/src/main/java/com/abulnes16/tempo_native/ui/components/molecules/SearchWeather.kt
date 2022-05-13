package com.abulnes16.tempo_native.ui.components.molecules

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Gray
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Shapes

@Composable
fun SearchWeather() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Gray,
                unfocusedIndicatorColor = Gray,
                focusedIndicatorColor = Primary
            ),
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 7.dp),
            shape = RoundedCornerShape(50.dp),
            placeholder = {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = null,
                        tint = Primary
                    )
                    Text(stringResource(id = R.string.city_name))
                }

            }

        )
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
        ) {
            Text(
                text = stringResource(id = R.string.search),
                color = Color.White
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun SearchWeatherPreview() {
    SearchWeather()
}