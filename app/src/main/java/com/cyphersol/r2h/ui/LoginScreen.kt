package com.cyphersol.r2h.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyphersol.r2h.ui.theme.R2hTheme


class LoginScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            R2hTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreenButtons()
                }
            }
        }
    }
}
@Composable
fun LoginScreenButtons() {
   Surface(
       modifier = Modifier.fillMaxSize()
   ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center

       ) {
           Column(
               verticalArrangement = Arrangement.spacedBy(10.dp)
           ) {
               Button(
                   onClick = {},
                   modifier = Modifier
                       .width(90.dp)
                       .height(40.dp)
               ) {
                   Text(text = "login")

               }
               Button(
                   onClick = {},
                   modifier = Modifier
                       .width(180.dp)
                       .height(40.dp)
               ) {
                   Text(text = "Sign up with google")

               }
           }
       }

   }
}

@Preview
@Composable
fun ShowPreview() {
    R2hTheme {
       LoginScreenButtons()
    }
}
