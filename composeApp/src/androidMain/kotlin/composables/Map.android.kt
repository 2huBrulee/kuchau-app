package composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
actual fun Map(modifier: Modifier) {
    val singapore = LatLng(2.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 12f)
    }
    
    Text("${cameraPositionState.position.target.latitude} ,${cameraPositionState.position.target.longitude} ")
    GoogleMap(
        modifier = modifier.fillMaxWidth(),
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(scrollGesturesEnabled = true)
    ) {
        Marker(
            draggable = true,
            state = MarkerState(position = singapore),
        )
    }
}