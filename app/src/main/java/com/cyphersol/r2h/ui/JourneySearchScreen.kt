package com.cyphersol.r2h.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
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
        Row( horizontalArrangement = Arrangement.Center,
             verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(60.dp).padding(start = 20.dp, end = 20.dp)) {
            FromDropDownMenu()
        }

    }
}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FromDropDownMenu() {
val contextForToast  = LocalContext.current.applicationContext
val listItems = (1..5).map { "option $it" }
var selectedItem by remember { mutableStateOf(listItems[0])}
var expanded by remember { mutableStateOf(false)}
var mTextFieldSize by remember {
    mutableStateOf(Size.Zero)
}
var icon = if (expanded)
    Icons.Filled.KeyboardArrowUp
    else
    Icons.Filled.KeyboardArrowDown
   OutlinedTextField(value = selectedItem,
                     onValueChange = {selectedItem = it},
                     modifier = Modifier
                         .fillMaxSize()
                         .onGloballyPositioned { layoutCoordinates ->
                             mTextFieldSize = layoutCoordinates.size.toSize()
                         },
                     label = {Text("Label")},
                     trailingIcon = {Icon(icon,"contentDescription",
                                         Modifier.clickable { expanded = !expanded })}


                    )
    DropdownMenu(expanded = expanded ,
        onDismissRequest = {expanded = false},
        modifier = Modifier.width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
    ){
     listItems.forEach {
         label -> DropdownMenuItem(onClick = {
         selectedItem = label
         expanded = false}){
             Text(text = label)
                         }
                       }
    }



/*    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true
        )
    }
*/





}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
JourneyScreen()
}