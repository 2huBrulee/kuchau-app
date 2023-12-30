package di

import com.google.android.gms.maps.model.LatLng
import composables.locationPicker.LocationPickerViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun appModule() = module {
    single { LocationPickerViewModel(LatLng(0.0, 0.0)) }
}


fun initKoin() {
    startKoin {
        modules(appModule())
    }
}
