package com.davidmatillacode.common.repository

import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.model.ListUnit

class TaskRepository(private val db: Database) {
    fun createTask(idProject: Long, desc: String, stimatedTime: Long) {
        db.taskSQLQueries.insertTask(idProject,desc,stimatedTime)
    }
    fun getTaskWithFilters(idProject: Long,searchFilter: String,tagId: Long?) : List<ListUnit.TaskUnit>{
        val taskList = (if (tagId == null) db.taskSQLQueries.selectTaskByFilters(
            idProject,
            searchFilter
        ).executeAsList()
        else db.taskSQLQueries.selectTaskByFiltersWithTags(
            tagId,
            idProject,
            searchFilter
        ).executeAsList())
        val taskListUnit = taskList.map { t ->
            ListUnit.TaskUnit(
                t.id_task,
                t.id_project,
                t.stimated_time,
                t.description
            )
        }
        for (task in taskListUnit) {
            //GET TASK TIMES FROM DB
            val times =
                db.taskTimesSQLQueries.getTaskTimes(task.id_task).executeAsList().map { t ->
                    ListUnit.TaskTimeUnit(t.id_task, t.start_time, t.end_time, t.state)
                }
            task.times.addAll(times)
            //GET TASK TAGS FROM DB
            val tags = db.tagsSQLQueries.selectTaskTags(task.id_task).executeAsList().map { t ->
                ListUnit.TagUnit(t.id_tag, t.description)
            }.sortedBy {
                it.id_tag
            }
            task.tags.addAll(tags)
        }
        return taskListUnit
    }
}