package composables.locationPicker

import androidx.compose.foundation.clickable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.google.android.gms.maps.model.LatLng
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import java.util.UUID


class LocationPickerScreen(
    private val onLocationPicked: (LatLng) -> Unit, private val label: String
) : Screen {
    @Composable
    override fun Content() {
        LocationPickerScreenContent(onLocationPicked, label)
    }
}

@Composable
fun LocationPicker(
    label: String,
    textField: @Composable (() -> Unit)? = null
) {
    val navigator = LocalNavigator.currentOrThrow
    val locationPickerViewModel = getViewModel(Unit, viewModelFactory {
        LocationPickerViewModel(LatLng(0.0, 0.0))
    })

    val uiState by locationPickerViewModel.uiState.collectAsState()



    val uuid by remember {
        mutableStateOf(UUID.randomUUID().toString())
    }

    if (textField == null) {
        Text(uuid)
        OutlinedTextField(
            enabled = false,
            readOnly = true,
            value = uiState.locationString,
            onValueChange = {},
            modifier = Modifier.clickable {
                navigator.push(LocationPickerScreen(
                    label = label,
                    onLocationPicked = {
                        locationPickerViewModel.updateLocation(it)
                    }

                ))
            },
            label = {
                Text(label)
            },
        )
    } else {
        textField()
    }
}


@Composable
fun LocationPickerScreenContent(
    onLocationPicked: (LatLng) -> Unit, label: String
) {
    val navigator = LocalNavigator.currentOrThrow
    var currentLocation by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            OutlinedTextField(
                readOnly = true,
                value = currentLocation,
                onValueChange = {},
                label = {
                    Text(label)
                }
            )
            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text("Done")
            }
        }
        LocationPickerMap(modifier = Modifier.weight(1f), initialPosition = null, onDragEnd = {
            val stringifiedLocation = it.toString()
            currentLocation = stringifiedLocation
            onLocationPicked(it)
        })
    }
}
