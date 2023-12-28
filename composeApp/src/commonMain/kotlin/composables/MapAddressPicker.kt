package composables

import androidx.compose.foundation.clickable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen


class AddressPickerScreen(
    private val onAddressPicked: (String)  -> Unit, private val label: String
) : Screen {
    @Composable
    override fun Content() {
        AddressPickerScreenContent(onAddressPicked, label)
    }
}

@Composable
fun MapAddressPicker(
    label: String,
    textField: @Composable (() -> Unit)? = null
) {
    val navigator = LocalNavigator.currentOrThrow
    var address by remember {
        mutableStateOf("")
    }

    if (textField == null) {
        OutlinedTextField(
            enabled = false,
            readOnly = true,
            value = address,
            onValueChange = {},
            modifier = Modifier.clickable {
                navigator push AddressPickerScreen(
                    label = label,
                    onAddressPicked = { it ->
                        address = it
                    }
                )
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
fun AddressPickerScreenContent(
    onAddressPicked: (String)  -> Unit,  label: String
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(label)
                }
            )
        }
        Map(modifier = Modifier.weight(1f))
    }
}
