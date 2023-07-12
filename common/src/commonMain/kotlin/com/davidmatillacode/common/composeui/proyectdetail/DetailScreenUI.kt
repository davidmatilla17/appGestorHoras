package com.davidmatillacode.common.composeui.proyectdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(){
    Scaffold {
        Column {
            Text("esto es un texto Detalle")
            TextButton(onClick = {}){
                Text("boton")
            } }

    }
}