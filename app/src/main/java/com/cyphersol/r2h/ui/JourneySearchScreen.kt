package com.cyphersol.r2h.ui

import android.os.Bundle
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.cyphersol.r2h.R
import com.cyphersol.r2h.ui.theme.R2hTheme

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
                text = stringResource(id = R.string.titleJourneySearch),
                fontSize = 30.sp
            )

        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(60.dp)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                DropDownMenu(stringResource(id = R.string.journeySearch_to))
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(60.dp)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                DropDownMenu(stringResource(id = R.string.journeySearch_from))
            }

        }
    }
}

@Composable
fun DropDownMenu(label: String) {
    val listItems = (1..5).map { "option $it" }
    var selectedItem by remember { mutableStateOf(listItems[0]) }
    var expanded by remember { mutableStateOf(false) }
    var mTextFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    OutlinedTextField(value = selectedItem,
        onValueChange = { selectedItem = it },
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { layoutCoordinates ->
                mTextFieldSize = layoutCoordinates.size.toSize()
            },
        label = { Text(label) },
        trailingIcon = {
            Icon(icon, "contentDescription",
                Modifier.clickable { expanded = !expanded })
        }


    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
    ) {
        listItems.forEach { label ->
            DropdownMenuItem(onClick = {
                selectedItem = label
                expanded = false
            }) {
                Text(text = label)
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JourneyScreen()
}