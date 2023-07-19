package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router

@Composable
 actual fun ListScreen(router: Router<Screens>,width : Int, height : Int){
    var menuOpen by remember { mutableStateOf(false) }
    Scaffold {

        Box {
            Column {
                IconButton(onClick = {
                    menuOpen = true
                }){
                    Icon(Icons.Default.Menu,"home")
                }
                ProjectListComponent()
            }
            if(menuOpen)
                menuLateralFilters{
                    menuOpen = false
                }
        }

    }
}