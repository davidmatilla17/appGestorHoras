package com.davidmatillacode.common.di

import com.davidmatillacode.common.viewmodel.CameraViewModel
import com.davidmatillacode.common.viewmodel.DialogsViewModel
import com.davidmatillacode.common.viewmodel.ProjectListViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton


val viewModelModule = DI.Module("ViewModelModule") {
    bind<ProjectListViewModel>() with singleton { ProjectListViewModel(instance()) }
    bind<DialogsViewModel>() with singleton { DialogsViewModel(instance(), instance(),instance(), instance()) }
    bind<CameraViewModel>() with singleton { CameraViewModel() }
}