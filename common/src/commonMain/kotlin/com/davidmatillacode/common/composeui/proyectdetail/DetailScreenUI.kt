package com.davidmatillacode.common.composeui.proyectdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router
import kotlin.random.Random

@Composable
fun DetailScreen(id : String, router: Router<Screens>,width : Int, height : Int) {

    Scaffold {
        Column {
            IconButton(onClick = {
                router.pop()
            }){
                Icon(Icons.Default.ArrowBack,"")
            }
            Text("esto es un texto Detalle")
            TextButton(onClick = {
                router.push(Screens.Details("${Random.nextInt()}"))
            }){
                Text("boton")
            } }

    }
}