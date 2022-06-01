package com.abulnes16.tempo_native.ui.components.molecules

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Gray
import com.abulnes16.tempo_native.ui.theme.Primary


@Composable
fun SearchWeather(onPress: (city: String) -> Unit) {
    val errorText = stringResource(id = R.string.blank_error)
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    var cityName by remember { mutableStateOf("") }
    val onSearch: () -> Unit = {
        if (cityName === "") {
            Toast
                .makeText(
                    context,
                    errorText, Toast.LENGTH_SHORT
                )
                .show()

        } else {
            onPress(cityName)
        }
    }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {

        OutlinedTextField(
            value = cityName,
            onValueChange = { city -> cityName = city },
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Color.Black,
                unfocusedIndicatorColor = Gray,
                focusedIndicatorColor = Primary
            ),
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth(0.6f)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),

            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = null,
                        tint = Primary
                    )
                    Text(stringResource(id = R.string.city_name), fontSize = 14.sp)
                }

            },
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )
        Button(
            onClick = onSearch,
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
            modifier = Modifier.height(50.dp)
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
    SearchWeather(onPress = { city -> Log.d("Preview", city) })
}