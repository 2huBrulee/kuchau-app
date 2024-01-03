import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ScreenFlow : Screen {

    @Composable
    override fun Content() {
        var data by remember {
            mutableStateOf("")
        }
        
        
        Navigator(Screen1(data))
    }
}


class Screen1(private var data: String) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column {


            OutlinedTextField(
                value = data,
                onValueChange = {},
                enabled = false
            )

            Button(onClick = {
                navigator.push(Screen2 {
                    data = it
                })
            }) {
                Text("GO")
            }
        }


    }
}

class Screen2(val onChange: (String) -> Unit) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var text by remember {
            mutableStateOf("")
        }

        Column {

            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                    onChange(it)
                }
            )

            Button(onClick = {
                navigator.pop()
            }) {
                Text("BACK")
            }
        }

    }
}