@file:OptIn(ExperimentalMaterialApi::class)

package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.davidmatillacode.common.composeui.utils.TextMediumBold
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.viewmodel.DialogsViewModel
import org.kodein.di.instance

@Composable
fun AddTagDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    AlertDialog(title = { TextMediumBold("Nueva Etiqueta") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddTagDialog(false)
        },text = {
            Text("dialogo")
        }, buttons = {})
}

@Composable
fun AddTaskDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    AlertDialog(title = { TextMediumBold("Nueva Tarea") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddTaskDialog(false)
        },text = {
            Text("dialogo")
        }, buttons = {})
}

@Composable
fun AddProjectDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    AlertDialog(title = { TextMediumBold("Nuevo Proyecto") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddProjectDialog(false)
        },text = {
            Text("dialogo")
        }, buttons = {})

}
