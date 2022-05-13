package com.abulnes16.tempo_native.ui.components.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.abulnes16.tempo_native.ui.theme.Primary
import com.abulnes16.tempo_native.ui.theme.Secondary
import com.abulnes16.tempo_native.ui.theme.Typography

@Composable
fun Title(title: String, color: Color = Secondary) {
    Text(
        text = title,
        style = Typography.h1,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    Title("Current time", Primary)
}