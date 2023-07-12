package com.davidmatillacode.common.composeui.proyectlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ListScreen(){
    Scaffold {
        Column {
            Text("esto es un texto Listado")
            TextButton(onClick = {}){
                Text("boton")
            } }

    }
}