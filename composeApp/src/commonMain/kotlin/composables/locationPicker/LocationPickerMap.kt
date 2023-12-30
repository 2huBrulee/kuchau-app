package composables.locationPicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng


@Composable
expect fun LocationPickerMap(
    modifier: Modifier = Modifier,
    initialPosition: LatLng? = null,
    onDragEnd: (location: LatLng) -> Unit
)