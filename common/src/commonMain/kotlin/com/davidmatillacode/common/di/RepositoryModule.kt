package com.davidmatillacode.common.di

import com.davidmatillacode.common.repository.ProjectRepository
import com.davidmatillacode.common.repository.TagRepository
import com.davidmatillacode.common.repository.TaskRepository
import com.davidmatillacode.common.viewmodel.ProjectListViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val RepositoryModule = DI.Module("Repository") {
    bind<ProjectRepository>() with singleton { ProjectRepository(instance(),instance()) }
    bind<TaskRepository>() with singleton { TaskRepository(instance()) }
    bind<TagRepository>() with singleton { TagRepository((instance())) }
}