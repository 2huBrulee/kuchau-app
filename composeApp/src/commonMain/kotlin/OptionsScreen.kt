import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator


class OptionsScreen : Screen {

    @Composable
    override fun Content() {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current


        Button(
            onClick = { bottomSheetNavigator.show(AnotherScreen()) }
        ) {
            Text(text = "Show BottomSheet")

        }
    }
}

class AnotherScreen : Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Text("XDD")

        }

    }
}