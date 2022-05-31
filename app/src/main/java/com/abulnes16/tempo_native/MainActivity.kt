package com.abulnes16.tempo_native

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.tempo_native.services.Api
import com.abulnes16.tempo_native.ui.screens.Home
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Tempo_NativeTheme
import com.abulnes16.tempo_native.viewmodels.TempoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<TempoViewModel>()
        super.onCreate(savedInstanceState)

        setContent {
            Tempo_NativeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    window?.statusBarColor = Primary.toArgb()
                    Home(
                        viewModel = viewModel
                    )
                }
            }
        }

        viewModel.getWeather()
    }
}