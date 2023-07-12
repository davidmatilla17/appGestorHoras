package com.davidmatillacode.common.composeui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MainContent(){
    Scaffold {
        Column {
            Text("esto es un texto")
            TextButton(onClick = {}){
                Text("boton")
            } }

    }
}