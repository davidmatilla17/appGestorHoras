package com.davidmatillacode.common.repository

import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.model.ListUnit

class ProjectRepository(val db: Database,val taskRepository: TaskRepository) {

    suspend fun getProjectWithFilters(
        searchFilter: String,
        tagId: Long?
    ): List<ListUnit.ProjectUnit> {
        val projectList = if (tagId != null) {
            db.projectSQLQueries.selectProjectByFiltersWithTags(
                id_tag = tagId,
                description = searchFilter
            ).executeAsList()
        } else if(!searchFilter.isEmpty()){
            db.projectSQLQueries.selectProjectByFilters(searchFilter).executeAsList()
        } else{
            db.projectSQLQueries.selectProjectByFilters("").executeAsList()
        }

        val projectListUnit =
            projectList.map { p -> ListUnit.ProjectUnit(p.id_project, p.description) }
        for (project in projectListUnit) {
            //GET TASK FROM DB
            val taskList = taskRepository.getTaskWithFilters(project.id_project,searchFilter,tagId)
            project.tasks.addAll(taskList)

            //GET TASK TAGS FROM DB
            val projectTags =
                db.tagsSQLQueries.selectProjectTags(project.id_project).executeAsList().map { t ->
                    ListUnit.TagUnit(t.id_tag, t.description)
                }.sortedBy {
                    it.id_tag
                }
            project.tags.addAll(projectTags)
        }
        return projectListUnit
    }

    suspend fun getAllTags(): List<ListUnit.TagUnit> {
        return db.tagsSQLQueries.selectAll().executeAsList()
            .map { t -> ListUnit.TagUnit(t.id_tag, t.description) }
    }

    suspend fun createProject(project: String) {
        db.projectSQLQueries.insertProject(project)
    }
}