package passenger.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen


class RequestARideScreen : Screen {

    @Composable
    override fun Content() {
        RequestARideScreen()
    }
}


@Composable
fun RequestARideScreenContent () {
    Text("Requesting a ride")
}