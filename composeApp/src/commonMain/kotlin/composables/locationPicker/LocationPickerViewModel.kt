package composables.locationPicker

import com.google.android.gms.maps.model.LatLng
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class LocationViewerUiState(
    val location: LatLng
) {
    val locationString = location.toString()
}


class LocationPickerViewModel(initialLocation: LatLng): ViewModel() {
    private val _uiState = MutableStateFlow(LocationViewerUiState(initialLocation))
    val uiState = _uiState.asStateFlow()
    
    fun updateLocation(
        newLocation: LatLng
    ) {
        _uiState.update {
            it.copy(location = newLocation)
        }
    }
}