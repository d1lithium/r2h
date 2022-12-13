package com.cyphersol.r2h.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyphersol.r2h.ui.theme.R2hTheme
import kotlin.math.exp

class JourneySearchScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            R2hTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JourneyScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JourneyScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Journey Search",
                fontSize = 30.sp
            )

        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "from: ",
                        fontSize = 20.sp
                    )
                }
                Row(horizontalArrangement = Arrangement.Start) {
                    FromDropDownMenu()
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "To: ",
                        fontSize = 20.sp
                    )
                }
                Row(horizontalArrangement = Arrangement.Start) {
                    FromDropDownMenu()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FromDropDownMenu() {
    val contextForToast  = LocalContext.current.applicationContext
    val listItems = arrayOf("Location 1","Location 2","Location 3")
    var selectedItem by remember { mutableStateOf(listItems[0])}
    var expanded by remember { mutableStateOf(false)}

    //box
    Box() {


        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                value = selectedItem,
                onValueChange = {},
                readOnly = true
            )
        }
    }
    //menu




}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JourneyScreen()
}