package com.davidmatillacode.common.model

sealed interface ListUnit {
    data class ProjectUnit(
        val id_project: Long,
        val description: String,
        val tasks : MutableList<TaskUnit> = ArrayList(),
        val tags : MutableList<TagUnit> = ArrayList()
    ) : ListUnit

    data class TaskUnit(
        val id_task: Long,
        val id_project: Long,
        val stimated_time: Long,
        val description: String,
        val tags : MutableList<TagUnit> = ArrayList(),
        val times : MutableList<TaskTimeUnit> = ArrayList()
    ) : ListUnit

    data class TagUnit(
        val id_tag: Long,
        val description: String,
    ) : ListUnit

    data class TaskTimeUnit(
        val id_task: Long?,
        val start_time: String,
        val end_time: String,
        val state: String,
    ) : ListUnit
}