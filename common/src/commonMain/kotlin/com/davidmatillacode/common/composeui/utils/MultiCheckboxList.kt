package com.davidmatillacode.common.composeui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
const val NOT_SELECTED = -1
const val NOT_SELECTED_LONG = -1L

@Composable
fun multiCheckBox(text: List <String>,selectedPos : Int?,onSelect :(Int)->Unit) {
    val newcheckDataRaw: MutableList<Boolean> = text.map { false }.toList().toMutableList()
    if((selectedPos ?: -1) >= 0) {
        selectedPos?.let {
            newcheckDataRaw[it] = true
        }
    }
    val checkValueStatus =  mutableStateOf(newcheckDataRaw)
    Column {
        text.forEachIndexed { i, t ->
            customCheckbox({ TextMedium(t) }, checkValueStatus.value[i]) {
                val checkDataRaw: MutableList<Boolean> = text.map { false }.toMutableList()
                checkDataRaw[i] = it
                checkValueStatus.value = checkDataRaw
                if(it) {
                    onSelect(i)
                } else{
                    onSelect(NOT_SELECTED)
                }
            }

        }
    }
}

@Composable
fun customCheckbox(text : @Composable () -> Unit,isChecked : Boolean,onCheckedChange: ((Boolean) -> Unit)?){
    Row (Modifier.fillMaxWidth().clickable(
        interactionSource = MutableInteractionSource(),
        indication = null,
        onClick = { onCheckedChange?.let { it(!isChecked) } }
    ),
        verticalAlignment = Alignment.CenterVertically){
        Box(Modifier.weight(0.8f).padding(start= paddingSmall), ){text()}
        Box(Modifier.weight(0.2f)){
            Checkbox( isChecked, onCheckedChange = onCheckedChange)
        }
    }
}