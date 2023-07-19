package com.davidmatillacode.android

import android.app.Application
import com.davidmatillacode.android.di.dbModule
import com.davidmatillacode.common.di.BaseDI
import com.davidmatillacode.common.di.viewModelModule
import org.kodein.di.DI
import org.kodein.di.android.x.androidXModule


class GestorHorasApplication : Application()  {
    val di = DI{
        // androidXModule (part of Kodein's android support library) gives us access to the context, as well as a lot of other Android services
        // see https://github.com/Kodein-Framework/Kodein-DI/blob/7.1/framework/android/kodein-di-framework-android-core/src/main/java/org/kodein/di/android/module.kt
        import(androidXModule(this@GestorHorasApplication))
        import(viewModelModule)
        import(dbModule)
    }

    override fun onCreate() {
        super.onCreate()
        val k = di
        BaseDI.di = di
        println(k)
    }
}