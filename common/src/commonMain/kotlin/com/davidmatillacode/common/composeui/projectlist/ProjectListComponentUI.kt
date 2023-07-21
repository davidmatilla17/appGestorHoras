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
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.model.ListUnit
import com.davidmatillacode.common.viewmodel.DialogsViewModel
import com.davidmatillacode.common.viewmodel.ProjectListViewModel
import org.kodein.di.instance

@Composable
fun ProjectListComponent() {
    val listViewModel by getAppDI().instance<ProjectListViewModel>()
    val projectList = listViewModel.stateProjectsList
    /*val defaultList = ArrayList<String>()
    for (x in 0..3) {
        defaultList.add(x.toString())
    }*/
    Column {
        LazyColumn(Modifier.padding(horizontal = paddingMedium).fillMaxSize()) {
            item {
                TextLargeBold("Proyectos")
                Spacer(Modifier.height(paddingLarge))
            }
            projectList.value.map {
                item {
                    projectDetail(it)
                }
            }
        }
    }
}

@Composable
private fun projectDetail(project : ListUnit.ProjectUnit) {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    Box{
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .background(backgroundLight)
                    .padding(horizontal = paddingSmall, vertical = paddingMinimun),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextMedium(project.description)
                IconButton(onClick = {
                    dialogsViewModel.setVisilityAddTaskDialog(true)
                }) {
                    Icon(Icons.Default.Add, "add")
                }
            }
            project.tasks.map {
                taskDetail(it)
            }
        }
    }
}

@Composable
private fun taskDetail(task : ListUnit.TaskUnit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = paddingSmall, vertical = paddingMinimun),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextMedium(
            task.description,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        IconButton(onClick = {}) {
            Icon(Icons.Default.Add, "add")
        }
    }
}