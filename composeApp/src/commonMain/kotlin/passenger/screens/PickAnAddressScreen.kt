package passenger.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen


class PickAnAddressScreen : Screen {

    @Composable
    override fun Content() {
        PickAnAddressScreenContent()
    }
}


@Composable
fun PickAnAddressScreenContent() {
    Text("Picking an adress")


}
