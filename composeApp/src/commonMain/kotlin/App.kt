import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.Navigator
import passenger.screens.RequestARideScreen
import passenger.screens.RequestARideScreenFlow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    MaterialTheme {
        Navigator(RequestARideScreenFlow())
    }
}