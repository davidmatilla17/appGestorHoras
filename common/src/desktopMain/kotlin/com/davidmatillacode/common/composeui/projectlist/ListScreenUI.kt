package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.davidmatillacode.common.composeui.CameraScreen
import com.davidmatillacode.common.composeui.utils.TextMedium
import com.davidmatillacode.common.composeui.utils.paddingLarge
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.navigator.Screens
import com.davidmatillacode.common.viewmodel.DialogsViewModel
import io.github.xxfast.decompose.router.Router
import org.kodein.di.instance

@Composable
actual fun ListScreen(router: Router<Screens>, width: Int, height: Int) {
    var menuOpen by remember { mutableStateOf(false) }
    if(false){
        CameraScreen(1,router,width,height)
    }else {
        val dialogsViewModel by getAppDI().instance<DialogsViewModel>()

        val isTaskDialogOpen = dialogsViewModel.stateAddTaskDialogVisible.value
        val isTagDialogOpen = dialogsViewModel.stateAddTagDialogVisible.value
        val isProjectDialogOpen = dialogsViewModel.stateAddProjectDialogVisible.value

        Scaffold(topBar = {
            if (width < 650)
                TopAppBar(title = {},
                    navigationIcon = {
                        IconButton(onClick = { menuOpen = !menuOpen }) {
                            Icon(Icons.Default.Menu, "home")
                        }
                    }
                )
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                dialogsViewModel.setVisilityAddProjectDialog(true)
            }) {
                Icon(Icons.Default.Add, "add")
            }
        }) {
            if (width < 650)
                screenWithLateralMenu(menuOpen) {
                    menuOpen = false
                }
            else
                screenLandscape(width)
        }

        if (isTagDialogOpen) {
            AddTagDialog()
        }

        if (isTaskDialogOpen) {
            AddTaskDialog()
        }
        if (isProjectDialogOpen) {
            AddProjectDialog()
        }
    }
}

@Composable
private fun screenLandscape(width: Int) {
    Row(Modifier.fillMaxWidth().fillMaxHeight()) {
        Box(
            modifier = Modifier.weight(0.3f)
        ) {
            FilterComponent()
        }
        Column(
            modifier = Modifier.weight(0.7f)
        ) {
            Spacer(Modifier.height(paddingLarge))
            ProjectListComponent()
        }
        if (width > 1200)
            Box(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun screenWithLateralMenu(menuOpen: Boolean, onOutClick: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Column {
            Spacer(Modifier.height(paddingLarge))
            ProjectListComponent()
        }
        if (menuOpen)
            menuLateralFilters(onOutClick)
    }
}
