package passenger.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.google.android.gms.maps.model.LatLng
import composables.StaticMap
import composables.locationPicker.LocationPicker
import composables.locationPicker.LocationPickerScreen
import composables.locationPicker.LocationPickerViewModel
import java.util.UUID


class RequestARideScreen(
    private val viewModel: RequestARideFlowViewModel
) : Screen {

    @Composable
    override fun Content() {
        RequestARideScreenContent(viewModel)
    }
}


@Composable
fun RequestARideScreenContent(viewModel: RequestARideFlowViewModel) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.uiState.collectAsState()

    val fakeCurrentPosition by remember {
        mutableStateOf(
            LatLng(
                -12.06110341576353, -77.05648403377131
            )
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        StaticMap(
            modifier = Modifier.weight(1f),
            centerOn = fakeCurrentPosition,
            markerPositions = arrayOf(fakeCurrentPosition)
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text("Requesting a ride")
            OutlinedTextField(
                enabled = false,
                readOnly = true,
                value = state.originString,
                onValueChange = {},
                modifier = Modifier.clickable {
                    navigator.push(LocationPickerScreen(
                        label = "Origin",
                        onLocationPicked = {
                            viewModel.setOrigin(it)
                        }

                    ))
                },
                label = {
                    Text("Origin")
                },
            )
            OutlinedTextField(
                enabled = false,
                readOnly = true,
                value = state.destinationString,
                onValueChange = {},
                modifier = Modifier.clickable {
                    navigator.push(LocationPickerScreen(
                        label = "Destination",
                        onLocationPicked = {
                            viewModel.setDestination(it)
                        }

                    ))
                },
                label = {
                    Text(text = "Destination")
                },
            )
            Button(
                onClick = {

                }
            ) {
                Text("Request")
            }
        }
    }

}