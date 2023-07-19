package com.davidmatillacode.common.composeui


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router

@Composable
fun CameraScreen(id : Long,
                        router: Router<Screens>,
                        width : Int, height : Int) {
    Scaffold {
        Column {
            IconButton(onClick = {
                router.pop()
            }) {
                Icon(Icons.Default.ArrowBack, "")
            }
            Text("esto es una foto")
        }

    }
}