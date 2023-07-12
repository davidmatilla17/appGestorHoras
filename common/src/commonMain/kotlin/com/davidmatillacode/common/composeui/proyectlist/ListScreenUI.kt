package com.davidmatillacode.common.composeui.proyectlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.push
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router
import kotlin.random.Random

@Composable
fun ListScreen(router: Router<Screens>){
    Scaffold {
        Column {
            Text("esto es un texto Listado")
            TextButton(onClick = {
                router.push(Screens.Details("${Random.nextInt()}"))
            }){
                Text("boton")
            } }

    }
}