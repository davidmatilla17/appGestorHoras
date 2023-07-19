package com.davidmatillacode.common.di

import org.kodein.di.DI

class BaseDI {
    companion object{
        lateinit var di: DI
    }
}

fun getAppDI() = BaseDI.di