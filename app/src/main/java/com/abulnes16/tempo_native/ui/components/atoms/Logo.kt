package com.abulnes16.tempo_native.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Secondary

@Composable
fun Logo() {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = painterResource(id = R.drawable.tempo_logo),
            contentDescription = null,
            modifier = Modifier.size(120.dp, 120.dp)
        )
        Text(
            text = stringResource(id = R.string.title),
            color = Secondary,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    Logo()
}