package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davidmatillacode.common.composeui.utils.TextLargeBold
import com.davidmatillacode.common.composeui.utils.TextMedium
import com.davidmatillacode.common.composeui.utils.TextMediumBold
import com.davidmatillacode.common.composeui.utils.TextMediumLarge
import com.davidmatillacode.common.composeui.utils.TextSmall
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
    LazyColumn(Modifier.padding(horizontal = paddingMedium).fillMaxSize()) {
        item(key = "column text") {
            TextLargeBold("Proyectos")
            Spacer(Modifier.height(paddingLarge))
        }
        items(count = projectList.value.size,
            key = {
                "${projectList.value[it].id_project}"
            }
        ) {
            projectDetail(projectList.value[it])
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun projectDetail(project: ListUnit.ProjectUnit) {
    val dialogsViewModel by getAppDI().instance<DialogsViewModel>()
    val projectListViewModel by getAppDI().instance<ProjectListViewModel>()
    Box {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .background(backgroundLight)
                    .padding(start = paddingSmall, end = paddingSmall, top = paddingMinimun),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextMediumLarge(project.description)
                IconButton(onClick = {
                    dialogsViewModel.setVisilityAddTaskDialog(project.id_project, true)
                }) {
                    Icon(Icons.Default.Add, "add")
                }
            }
            if (project.tags.isNotEmpty())
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(100.dp),
                    modifier = Modifier.heightIn(50.dp, 150.dp).background(backgroundLight)
                ) {
                    items(project.tags.size) {
                        Box(modifier = Modifier.padding(start = paddingSmall)) {
                            Chip(
                                onClick = {
                                    projectListViewModel.updateTagFilter(project.tags[it].id_tag)
                                },
                                border = ChipDefaults.outlinedBorder,
                                colors = ChipDefaults.chipColors(
                                    backgroundColor = Color.White
                                )
                            ) {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    TextSmall(project.tags[it].description, maxLines = Int.MAX_VALUE)
                                    Icon(
                                        Icons.Rounded.Close,
                                        "",
                                        modifier = Modifier.clickable { println("cliiiiick") })
                                }
                            }

                        }
                    }
                }
            project.tasks.map {
                taskDetail(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun taskDetail(task: ListUnit.TaskUnit) {
    val projectListViewModel by getAppDI().instance<ProjectListViewModel>()
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = paddingSmall, vertical = paddingMinimun),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextMedium(
                task.description,
                modifier = Modifier
            )
            TextMediumBold(
                "${task.stimated_time}h",
                modifier = Modifier
            )
        }
        if (task.tags.isNotEmpty())
            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                modifier = Modifier.heightIn(50.dp, 150.dp)
            ) {
                items(task.tags.size) {
                    Box(modifier = Modifier.padding(start = paddingSmall)) {
                        Chip(
                            onClick = {
                                projectListViewModel.updateTagFilter(task.tags[it].id_tag)
                            },
                            border = ChipDefaults.outlinedBorder,
                            colors = ChipDefaults.chipColors(
                                backgroundColor = Color.White
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextSmall(task.tags[it].description, maxLines = Int.MAX_VALUE)
                                Icon(
                                    Icons.Rounded.Close,
                                    "",
                                    modifier = Modifier.clickable { println("cliiiiick") })
                            }
                        }

                    }
                }
            }
        Box(modifier = Modifier.height(1.dp).fillMaxWidth().background(backgroundLight))
    }

}