package com.cyphersol.r2h

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyphersol.r2h.ui.theme.R2hTheme

class LoadingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            R2hTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loadingScreen()
                }
            }
        }
    }
}

@Composable
fun loadingScreen() {
    Surface(color = Color.Black,
    modifier = Modifier.fillMaxSize()) {

        Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 80.sp,
                color = Color.White
            )

            LinearProgressIndicator(
             color = Color.Green


            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    R2hTheme {
        loadingScreen()
    }
}