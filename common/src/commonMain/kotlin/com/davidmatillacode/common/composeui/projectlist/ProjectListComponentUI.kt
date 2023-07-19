package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.davidmatillacode.common.composeui.utils.TextLargeBold
import com.davidmatillacode.common.composeui.utils.TextMedium
import com.davidmatillacode.common.composeui.utils.backgroundLight
import com.davidmatillacode.common.composeui.utils.paddingLarge
import com.davidmatillacode.common.composeui.utils.paddingMedium
import com.davidmatillacode.common.composeui.utils.paddingMinimun
import com.davidmatillacode.common.composeui.utils.paddingSmall

@Composable
fun ProjectListComponent() {
    val defaultList = ArrayList<String>()
    for (x in 0..3) {
        defaultList.add(x.toString())
    }
    Column {
        LazyColumn(Modifier.padding(horizontal = paddingMedium).fillMaxSize()) {
            item {
                TextLargeBold("Proyectos")
                Spacer(Modifier.height(paddingLarge))
            }
            defaultList.map {
                item {
                    projectDetail()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun projectDetail() {
    val defaultList = ArrayList<String>()
    for (x in 0..3) {
        defaultList.add(x.toString())
    }
    var openDialog by remember { mutableStateOf(false) }
    Box{
        if(openDialog)
        AlertDialog(onDismissRequest = {
            openDialog = false
        }, title = {
            Text(text = "Title")
        }, text = {
            Text("dialogo")
        }, buttons = {})
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .background(backgroundLight)
                    .padding(horizontal = paddingSmall, vertical = paddingMinimun),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextMedium("Nombre Projecto 1")
                IconButton(onClick = {
                    openDialog = true
                }) {
                    Icon(Icons.Default.Add, "add")
                }
            }
            defaultList.map {
                taskDetail()
            }
        }
    }
}

@Composable
private fun taskDetail() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = paddingSmall, vertical = paddingMinimun),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextMedium(
            "Detalle de tareaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        IconButton(onClick = {}) {
            Icon(Icons.Default.Add, "add")
        }
    }
}