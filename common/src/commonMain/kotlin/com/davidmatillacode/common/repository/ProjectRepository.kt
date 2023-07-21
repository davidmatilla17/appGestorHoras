package com.davidmatillacode.common.repository

import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.model.ListUnit
import comdavidmatillacodecommondb.Project
import org.kodein.di.instance

class ProjectRepository {

    suspend fun getProjectWithFilters(searchFilter : String, tagId : Long?) : List<ListUnit.ProjectUnit>{
        val db: Database by getAppDI().instance()
        val projectList  =( if(tagId == null) db.projectSQLQueries.selectProjectByFilters(searchFilter).executeAsList()
        else db.projectSQLQueries.selectProjectByFiltersWithTags(id_tag = tagId, description =  searchFilter).executeAsList())

        val projectListUnit = projectList.map { p-> ListUnit.ProjectUnit(p.id_project,p.description) }
        for(project in projectListUnit){
            //GET TASK FROM DB
            val taskList  =( if(tagId == null) db.taskSQLQueries.selectTaskByFilters(project.id_project, searchFilter).executeAsList()
            else db.taskSQLQueries.selectTaskByFiltersWithTags(tagId,project.id_project, searchFilter).executeAsList())
            val taskListUnit = taskList.map { t -> ListUnit.TaskUnit(t.id_task,t.id_project,t.stimated_time,t.description) }
            project.tasks.addAll(taskListUnit)
            for(task in project.tasks){
                //GET TASK TIMES FROM DB
                val times = db.taskTimesSQLQueries.getTaskTimes(task.id_task).executeAsList().map { t->
                    ListUnit.TaskTimeUnit(t.id_task,t.start_time,t.end_time,t.state)
                }
                task.times.addAll(times)
                //GET TASK TAGS FROM DB
                val tags = db.tagsSQLQueries.selectTaskTags(task.id_task).executeAsList().map { t->
                    ListUnit.TagUnit(t.id_tag,t.description)
                }
                task.tags.addAll(tags)
            }
            //GET TASK TAGS FROM DB
            val projectTags = db.tagsSQLQueries.selectProjectTags(project.id_project).executeAsList().map { t->
                ListUnit.TagUnit(t.id_tag,t.description)
            }
            project.tags.addAll(projectTags)
        }
        return projectListUnit
    }

    suspend fun getAllTags(): List<ListUnit.TagUnit> {
        val db: Database by getAppDI().instance()
        return db.tagsSQLQueries.selectAll().executeAsList().map { t -> ListUnit.TagUnit(t.id_tag,t.description) }
    }
}