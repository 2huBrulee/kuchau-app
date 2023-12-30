package composables.locationPicker

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.delay


@Composable
actual fun LocationPickerMap(
    modifier: Modifier,
    initialPosition: LatLng?,
    onDragEnd: (location: LatLng) -> Unit
) {
    val location by remember {
        mutableStateOf(
            initialPosition ?: LatLng(
                -12.06110341576353, -77.05648403377131
            )
        )
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 14f)
    }

    val locationMarkerState = rememberMarkerState(position = location)
    val lastLocationMarked by remember {
        mutableStateOf(locationMarkerState.position)
    }

    LaunchedEffect(locationMarkerState.position) {
        delay(800)

        if (locationMarkerState.position != lastLocationMarked)
            onDragEnd(locationMarkerState.position)
    }

    GoogleMap(
        modifier = modifier.fillMaxWidth(),
        properties = MapProperties(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            draggable = true,
            state = locationMarkerState,

            )
    }


}
