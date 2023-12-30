package composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng

@Composable
expect fun StaticMap(
    modifier: Modifier = Modifier,
    centerOn: LatLng,
    markerPositions: Array<LatLng>,
)