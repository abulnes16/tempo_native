import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.tempo_native.models.Forecast
import com.abulnes16.tempo_native.ui.components.atoms.Title
import com.abulnes16.tempo_native.ui.components.molecules.ForecastItem

@Composable
fun ForecastList(forecast: List<Forecast>) {
    Column(modifier = Modifier.padding(10.dp)) {
        Title(title = "Weekly Forecast")
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
    val forecast = listOf<Forecast>(
        Forecast("Wind", "Lu", "25"),
        Forecast("Wind", "Ma", "29"),
        Forecast("Wind", "Mi", "20"),
        Forecast("Wind", "Ju", "30"),
    )
    ForecastList(forecast = forecast)
}