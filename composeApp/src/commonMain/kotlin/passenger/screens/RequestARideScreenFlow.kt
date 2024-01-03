package passenger.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.google.android.gms.maps.model.LatLng
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class RequestARideFlowUiState(
    val origin: LatLng,
    val destination: LatLng
) {
    val originString = origin.toString()
    val destinationString = destination.toString()
}

class RequestARideFlowViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(RequestARideFlowUiState(origin = LatLng(0.0, 0.0), destination = LatLng(0.0, 0.0)))

    val uiState = _uiState.asStateFlow()

    fun setOrigin(newOrigin: LatLng) {
        _uiState.update {
            it.copy(
                origin = newOrigin
            )
        }
    }

    fun setDestination(
        newDestination: LatLng
    ) {
        _uiState.update {
            it.copy(
                destination = newDestination
            )
        }
    }


}


class RequestARideScreenFlow : Screen {

    @Composable
    override fun Content() {
        RequestARideScreenFlowContent()
    }
}

@Composable
fun RequestARideScreenFlowContent() {
    val viewModel = getViewModel(Unit, viewModelFactory {
        RequestARideFlowViewModel()
    })

    val state by viewModel.uiState.collectAsState()


    Navigator(RequestARideScreen(viewModel))
}