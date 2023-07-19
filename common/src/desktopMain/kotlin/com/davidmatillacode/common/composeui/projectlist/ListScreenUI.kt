package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import com.davidmatillacode.common.composeui.utils.paddingLarge
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router

@Composable
actual fun ListScreen(router: Router<Screens>, width: Int, height: Int) {
    Scaffold {
      if (width < 650)
          screenWithLateralMenu()
        else
            screenLandscape(width)
    }
}

@Composable
private fun screenLandscape(width: Int){
    Row(Modifier.fillMaxWidth().fillMaxHeight()) {
        Box(
            modifier = Modifier.weight(0.3f)
        ){
            FilterComponent()
        }
        Column(
            modifier = Modifier.weight(0.7f)
        ){
            Spacer(Modifier.height(paddingLarge))
            ProjectListComponent()
        }
        if(width > 1200)
            Box(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun screenWithLateralMenu(){
    var menuOpen by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize()) {
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
