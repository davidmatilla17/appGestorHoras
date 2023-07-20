package com.davidmatillacode.common.composeui.projectlist

import CustomOutlinedTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davidmatillacode.common.composeui.utils.TextLargeBold
import com.davidmatillacode.common.composeui.utils.TextMedium
import com.davidmatillacode.common.composeui.utils.TextMediumBold
import com.davidmatillacode.common.composeui.utils.TextSmallBold
import com.davidmatillacode.common.composeui.utils.customCheckbox
import com.davidmatillacode.common.composeui.utils.multiCheckBox
import com.davidmatillacode.common.composeui.utils.paddingLarge
import com.davidmatillacode.common.composeui.utils.paddingMedium
import com.davidmatillacode.common.composeui.utils.paddingSmall

@Composable
fun FilterComponent() {
    val textListPrueba = ArrayList<String>()
    for(x in 1..20){
        textListPrueba.add("texto tag ${x}")
    }
    var textValue by remember { mutableStateOf("") }
    Card(Modifier.fillMaxWidth().padding(horizontal = paddingMedium), elevation = 0.dp) {
        LazyColumn {
            item {
                Spacer(Modifier.height(paddingLarge))
                TextLargeBold("Filtros", modifier = Modifier.padding(start = paddingSmall))
                Spacer(Modifier.height(paddingSmall))
            }
            item {
                CustomOutlinedTextField(
                    value = textValue,
                    onValueChange = { textValue = it },
                    readOnly = false,
                    singleLine = true,

                    placeholder = { TextMedium("Search") },
                    maxLines = 1,
                    shape = MaterialTheme.shapes.small.copy(CornerSize(100)),
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(Modifier.height(paddingSmall))
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextMediumBold("Tags", modifier = Modifier.padding(start = paddingSmall))
                    OutlinedButton(
                        onClick = {},
                        shape = MaterialTheme.shapes.small.copy(CornerSize(100))
                    ) {
                        Icon(Icons.Default.Add, "add")
                        TextSmallBold("Añadir")
                    }
                }
            }
            item{
                multiCheckBox(textListPrueba)
            }
            item{
                Spacer(Modifier.height(paddingLarge))
            }
        }
    }
}

@Composable
fun menuLateralFilters(backgroundClose: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxSize().background(Color.Black.copy(alpha = 0.6f)).clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = {
                backgroundClose()
            }
        )) {

        Box(Modifier.fillMaxHeight().fillMaxWidth(0.7f).background(Color.White).clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = {}
        )) {
            FilterComponent()
        }
        Box(
            modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = backgroundClose
            )
        )
    }
}