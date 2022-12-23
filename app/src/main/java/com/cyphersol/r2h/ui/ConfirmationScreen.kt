package com.cyphersol.r2h.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cyphersol.r2h.ui.theme.R2hTheme

class ConfirmationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            R2hTheme {
                ChoiceScreen(isSuccess = true)
            }
        }
    }

    @Composable
    fun ChoiceScreen(isSuccess: Boolean) {
        if (isSuccess) {
            SuccessScreen()
        } else {
            FailureScreen()
        }
    }

    @Composable
    fun SuccessScreen() {
        Column(verticalArrangement = Arrangement.Center) {

        }
    }

    @Composable
    fun FailureScreen() {

    }

    @Preview(showBackground = true)
    @Composable
    fun Preview3() {
        R2hTheme {
            ChoiceScreen(isSuccess = true)
        }
    }
}