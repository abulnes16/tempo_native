package com.abulnes16.tempo_native.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.ui.theme.Danger
import com.abulnes16.tempo_native.ui.theme.Typography

@Composable
fun ErrorMessage(
    text: String = stringResource(id = R.string.generic_error)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 0.dp, vertical = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_error),
            contentDescription = null,
            tint = Danger,
            modifier = Modifier
                .size(60.dp)
                .padding(horizontal = 0.dp, vertical = 5.dp)
        )
        Text(text = text, style = Typography.body1)
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorMessagePreview() {
    ErrorMessage()
}