import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import composables.Map
import dev.icerock.moko.resources.compose.painterResource
import org.simios.kuchau_app.resources.AppResources

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    var isDialogOpen by remember { mutableStateOf(false) }


    MaterialTheme {
        BottomSheetNavigator {
            val bsn = LocalBottomSheetNavigator.current
            Column(modifier = Modifier.fillMaxSize()) {
                Map(modifier = Modifier.fillMaxSize().weight(weight = 1f))
                Button(onClick = {
                    bsn.show(AnotherScreen())
                }) {
                    Icon(
                        painter = painterResource(AppResources.images.pistol),
                        contentDescription = null,
                        tint = Color(0xFF00FFFF),
                        modifier = Modifier.height(18.dp)
                    )
                    Text("Click me!")
                }
                Image(painterResource(AppResources.images.kuchau), null)

            }


//            if (isDialogOpen) {
//                Dialog(
//                    onDismissRequest = {
//                        isDialogOpen = false
//                    },
//                    properties = DialogProperties()
//                ) {
//                    Surface(
//                        color = Color.Black,
//                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
//                    ) {
//                        Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
//                            Row(verticalAlignment = Alignment.CenterVertically) {
//                                Text(
//                                    "HellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellowHellow",
//                                    color = Color.White,
//                                    modifier = Modifier.weight(1f)
//                                )
//                                Image(
//                                    painter = painterResource(AppResources.images.kuchau),
//                                    contentDescription = null,
//                                    modifier = Modifier.weight(1f)
//                                )
//                            }
//                            Button(
//                                onClick = {}, colors = ButtonDefaults.buttonColors(
//                                    backgroundColor = Color.Yellow
//                                )
//                            ) {
//                                Text("Clicky", color = Color.Black)
//                            }
//
//                        }
//
//                    }
//                }
//            }


        }
    }
}