package com.davidmatillacode.common.viewmodel

import ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.davidmatillacode.common.repository.ProjectRepository
import com.davidmatillacode.common.repository.TagRepository
import com.davidmatillacode.common.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DialogsViewModel(
    private val projectRepo: ProjectRepository,
    private val tagRepo: TagRepository,
    private val taskRepo: TaskRepository,
    private val projectListViewModel: ProjectListViewModel
) : ViewModel() {
    val _stateAddTagDialogVisible = mutableStateOf(false)
    val stateAddTagDialogVisible: State<Boolean> = _stateAddTagDialogVisible

    val _stateAddTaskDialogVisible = mutableStateOf(false)
    val stateAddTaskDialogVisible: State<Boolean> = _stateAddTaskDialogVisible

    val _stateAddProjectDialogVisible = mutableStateOf(false)
    val stateAddProjectDialogVisible: State<Boolean> = _stateAddProjectDialogVisible

    private var taskDialogIdProject : Long? = null

    fun setVisilityAddTagDialog(visible: Boolean) {
        _stateAddTagDialogVisible.value = visible
    }

    public fun getTaskDialogIdProject() = taskDialogIdProject
    fun setVisilityAddTaskDialog(idProject:Long?,visible: Boolean) {
        taskDialogIdProject = idProject
        _stateAddTaskDialogVisible.value = visible
    }

    fun setVisilityAddProjectDialog(visible: Boolean) {
        _stateAddProjectDialogVisible.value = visible
    }

    fun addNewTag(tag: String) {
        launch(Dispatchers.IO) {
            tagRepo.createTag(tag)
            projectListViewModel.getAllTags()
        }
    }

    fun addNewProject(project: String) {
        launch {
            projectRepo.createProject(project)
            projectListViewModel.updateAllData()
        }
    }
    fun addNewTask(idProject: Long, desc: String, stimatedTime: Long){
        launch {
            taskRepo.createTask(idProject,desc,stimatedTime)
            projectListViewModel.updateAllData()
        }
    }
}