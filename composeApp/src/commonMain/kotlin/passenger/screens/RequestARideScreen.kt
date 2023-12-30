package passenger.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.google.android.gms.maps.model.LatLng
import composables.StaticMap
import composables.locationPicker.LocationPicker
import composables.locationPicker.LocationPickerViewModel
import java.util.UUID


class RequestARideScreen : Screen {
    private val uuid = UUID.randomUUID().toString()

    @Composable
    override fun Content() {
        RequestARideScreenContent(uuid)
    }
}


@Composable
fun RequestARideScreenContent(key: ScreenKey) {
    val navigator = LocalNavigator.currentOrThrow
    val screenId by remember {
        mutableStateOf(UUID.randomUUID().toString())
    }
    val fakeCurrentPosition by remember {
        mutableStateOf(
            LatLng(
                -12.06110341576353, -77.05648403377131
            )
        )
    }

//    val vm = LocationPickerViewModel by inject()

    Column(modifier = Modifier.fillMaxSize()) {
        Text("$screenId")
        Text("$key")
        StaticMap(
            modifier = Modifier.weight(1f),
            centerOn = fakeCurrentPosition,
            markerPositions = arrayOf(fakeCurrentPosition)
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text("Requesting a ride")
            LocationPicker(
                "Origin"
            )
            LocationPicker(
                "Destination"
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