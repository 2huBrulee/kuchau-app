import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.Navigator
import passenger.screens.RequestARideScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    var isDialogOpen by remember { mutableStateOf(false) }


    MaterialTheme {
        Navigator(listOf(RequestARideScreen(), RequestARideScreen()))


//        BottomSheetNavigator {
//            val bsn = LocalBottomSheetNavigator.current
//            Column(modifier = Modifier.fillMaxSize()) {
//                Map(modifier = Modifier.fillMaxSize().weight(weight = 1f))
//                Button(onClick = {
//                    bsn.show(AnotherScreen())
//                }) {
//                    Icon(
//                        painter = painterResource(AppResources.images.pistol),
//                        contentDescription = null,
//                        tint = Color(0xFF00FFFF),
//                        modifier = Modifier.height(18.dp)
//                    )
//                    Text("Click me!")
//                }
//                Image(painterResource(AppResources.images.kuchau), null)
//
//            }


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


//        }
    }
}