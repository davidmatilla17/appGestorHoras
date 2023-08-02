@file:OptIn(ExperimentalMaterialApi::class)

package com.davidmatillacode.common.composeui.projectlist

import CustomOutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.davidmatillacode.common.composeui.utils.TextLargeBold
import com.davidmatillacode.common.composeui.utils.TextSmallBold
import com.davidmatillacode.common.composeui.utils.paddingSmall
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.viewmodel.DialogsViewModel
import com.davidmatillacode.common.viewmodel.ProjectListViewModel
import org.kodein.di.instance

@Composable
fun AddTagDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    var tagText = remember { mutableStateOf("") }
    AlertDialog(title = { TextLargeBold("Nueva Etiqueta") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddTagDialog(false)
        }, text = {
            Column(Modifier.padding(top = paddingSmall)) {
                TextSmallBold("Nombre de la etiqueta")
                CustomOutlinedTextField(value = tagText.value, onValueChange = {
                    tagText.value = it
                }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(paddingSmall))
            }
        }, buttons = {
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = {
                    dialogsViewModel.setVisilityAddTagDialog(false)
                }) {
                    TextSmallBold("Cancelar")
                }
                TextButton(onClick = {
                    dialogsViewModel.setVisilityAddTagDialog(false)
                    dialogsViewModel.addNewTag(tagText.value)
                }) {
                    TextSmallBold("Crear")
                }
                Spacer(Modifier.width(paddingSmall))
            }
        }, modifier = Modifier.width(300.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddTaskDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    val taskText = remember { mutableStateOf("") }
    val taskTime = remember { mutableStateOf("") }
    val pattern = remember { Regex("^\\d+\$") }

    AlertDialog(title = { TextLargeBold("Nueva Etiqueta") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddTaskDialog(null,false)
        }, text = {
            Column(Modifier.padding(top = paddingSmall)) {
                TextSmallBold("Nombre de la tarea")
                CustomOutlinedTextField(
                    taskText.value,
                    onValueChange = { taskText.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
                TextSmallBold("Tiempo estimado")
                CustomOutlinedTextField(
                    taskTime.value, onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            taskTime.value = it
                        }
                    }, modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(Modifier.height(paddingSmall))
            }

        }, buttons = {
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = {
                    dialogsViewModel.setVisilityAddTaskDialog(null,false)
                }) {
                    TextSmallBold("Cancelar")
                }
                TextButton(onClick = {
                    dialogsViewModel.addNewTask(dialogsViewModel.getTaskDialogIdProject()?:0,taskText.value,taskTime.value.toLong())
                    dialogsViewModel.setVisilityAddTaskDialog(null,false)
                }) {
                    TextSmallBold("Crear")
                }
                Spacer(Modifier.width(paddingSmall))
            }
        }, modifier = Modifier.width(300.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddProjectDialog() {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    val projectText = remember { mutableStateOf("") }

    AlertDialog(title = { TextLargeBold("Nuevo proyecto") },
        onDismissRequest = {
            dialogsViewModel.setVisilityAddProjectDialog(false)
        }, text = {
            Column(Modifier.padding(top = paddingSmall)) {
                TextSmallBold("Nombre del proyecto")
                CustomOutlinedTextField(
                    projectText.value,
                    onValueChange = { projectText.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(paddingSmall))
            }
        }, buttons = {
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = {
                    dialogsViewModel.setVisilityAddProjectDialog(false)
                }) {
                    TextSmallBold("Cancelar")
                }
                TextButton(onClick = {
                    dialogsViewModel.addNewProject(projectText.value)
                    dialogsViewModel.setVisilityAddProjectDialog(false)
                }) {
                    TextSmallBold("Crear")
                }
                Spacer(Modifier.width(paddingSmall))
            }
        }, modifier = Modifier.width(300.dp)
    )
}
