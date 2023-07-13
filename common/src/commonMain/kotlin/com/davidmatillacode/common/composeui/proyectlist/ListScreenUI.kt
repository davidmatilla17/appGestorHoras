package com.davidmatillacode.common.composeui.proyectlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router
import kotlin.random.Random

@Composable
fun ListScreen(router: Router<Screens>,width : Int, height : Int){
    Scaffold {
        Column(verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {
            Text("esto es un texto Listado")
            TextButton(onClick = {
                router.push(Screens.Details("${Random.nextInt()}"))
            }){
                Text("boton")
            } }

    }
}