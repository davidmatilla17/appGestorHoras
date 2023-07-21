package com.davidmatillacode.common.viewmodel

import ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.davidmatillacode.common.composeui.utils.NOT_SELECTED_LONG

class DialogsViewModel : ViewModel() {
    val _stateAddTagDialogVisible = mutableStateOf(false)
    val stateAddTagDialogVisible: State<Boolean> = _stateAddTagDialogVisible

    val _stateAddTaskDialogVisible = mutableStateOf(false)
    val stateAddTaskDialogVisible: State<Boolean> = _stateAddTaskDialogVisible

    val _stateAddProjectDialogVisible = mutableStateOf(false)
    val stateAddProjectDialogVisible: State<Boolean> = _stateAddProjectDialogVisible

    fun setVisilityAddTagDialog(visible : Boolean){
        _stateAddTagDialogVisible.value = visible
    }

    fun setVisilityAddTaskDialog(visible : Boolean){
        _stateAddTaskDialogVisible.value = visible
    }

    fun setVisilityAddProjectDialog(visible : Boolean){
        _stateAddProjectDialogVisible.value = visible
    }
}