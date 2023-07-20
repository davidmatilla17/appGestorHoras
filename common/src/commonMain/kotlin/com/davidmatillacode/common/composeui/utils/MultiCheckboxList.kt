package com.davidmatillacode.common.composeui.utils

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color

@Composable
fun multiCheckBox(text : List<String>) {
    val checkDataRaw: List<Boolean> = text.map { false }.toList()
    var checkValueStatus = remember { mutableStateOf(checkDataRaw) }
    Column {
        text.forEachIndexed { i, t ->
            customCheckbox({ TextMedium(t) }, checkValueStatus.value[i]) {
                val checkDataRaw: MutableList<Boolean> = text.map { false }.toList() as MutableList<Boolean>
                checkDataRaw[i] = it
                checkValueStatus.value = checkDataRaw
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