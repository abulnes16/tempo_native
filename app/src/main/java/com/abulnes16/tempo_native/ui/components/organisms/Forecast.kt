import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.R
import com.abulnes16.tempo_native.models.Forecast
import com.abulnes16.tempo_native.models.WeatherType
import com.abulnes16.tempo_native.ui.components.atoms.Title
import com.abulnes16.tempo_native.ui.components.molecules.ForecastItem
import com.abulnes16.tempo_native.ui.theme.Primary

@Composable
fun ForecastList(forecast: List<Forecast>) {
    Column(modifier = Modifier.padding(10.dp)) {
        Title(title = stringResource(id = R.string.weekly_forecast))
        LazyRow(modifier = Modifier.padding(vertical = 5.dp)) {
            items(forecast) { f ->
                ForecastItem(forecast = f)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastListPreview() {
    val weatherType = WeatherType(R.drawable.ic_baseline_wb_cloudy, Primary)
    val forecast = listOf<Forecast>(
        Forecast(weatherType, "Lu", "25"),
        Forecast(weatherType, "Ma", "29"),
        Forecast(weatherType, "Mi", "20"),
        Forecast(weatherType, "Ju", "30"),
    )
    ForecastList(forecast = forecast)
}