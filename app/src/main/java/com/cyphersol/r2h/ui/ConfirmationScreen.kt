package com.cyphersol.r2h.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.cyphersol.r2h.ui.theme.R2hTheme

class ConfirmationScreen: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent { 
            R2hTheme{
             ChoiceScreen(isSuccess = true)   
            }
        }
    }
    @Composable
    fun ChoiceScreen(isSuccess: Boolean){
        if(isSuccess){
            SuccessScreen()
        }
        else{
            FailureScreen()
        }
    }
    @Composable
    fun SuccessScreen(){

    }
    @Composable
    fun FailureScreen(){
        
    }
}