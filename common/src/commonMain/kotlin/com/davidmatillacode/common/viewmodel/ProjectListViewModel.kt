package com.davidmatillacode.common.viewmodel

import ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.davidmatillacode.common.composeui.utils.NOT_SELECTED
import com.davidmatillacode.common.composeui.utils.NOT_SELECTED_LONG
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.model.ListUnit
import com.davidmatillacode.common.repository.ProjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.instance

class ProjectListViewModel(private val repository : ProjectRepository) : ViewModel() {

    val _stateSearchFilter = mutableStateOf("")
    val stateSearchFilter: State<String> = _stateSearchFilter

    val _stateTagFilter = mutableStateOf(NOT_SELECTED_LONG)
    val stateTagFilter: State<Long> = _stateTagFilter

    val _stateProjectsList = mutableStateOf<List<ListUnit.ProjectUnit>>(ArrayList())
    val stateProjectsList : State<List<ListUnit.ProjectUnit>> = _stateProjectsList

    val _stateTagsList = mutableStateOf<List<ListUnit.TagUnit>>(ArrayList())
    val stateTagsList : State<List<ListUnit.TagUnit>> = _stateTagsList

    init {
        getAllTags()
        updateSearchFilter("")
    }

    fun updateSearchFilter(value : String){
        _stateSearchFilter.value = value
        updateAllData()
    }

    fun updateTagFilter(tagId : Long){
        _stateTagFilter.value = tagId
        updateAllData()
    }

    fun updateAllData(){
        launch{
            val searchText = stateSearchFilter.value.trim()
            val tag = if(stateTagFilter.value != NOT_SELECTED_LONG ) stateTagFilter.value  else null
            val result = repository.getProjectWithFilters(searchText,tag)
            _stateProjectsList.value = result
        }
    }

    fun getAllTags(){
        launch {
            _stateTagsList.value = repository.getAllTags()
        }
    }
}