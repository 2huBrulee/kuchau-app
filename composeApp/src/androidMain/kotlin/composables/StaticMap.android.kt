package composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
actual fun StaticMap(
    modifier: Modifier,
    centerOn: LatLng,
    markerPositions: Array<LatLng>,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(centerOn, 14f)
    }

    GoogleMap(
        modifier = modifier.fillMaxWidth(),
        properties = MapProperties(),
        cameraPositionState = cameraPositionState
    ) {
        for (markerPosition in markerPositions) {
            Marker(
                state = MarkerState(
                    position = markerPosition
                )
            )
        }
    }


}