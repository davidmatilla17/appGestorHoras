package com.davidmatillacode.common.viewmodel

import ViewModel

expect class CameraViewModel : ViewModel{

    fun switchCamera()
    fun isOpenCamera(): Boolean
    fun getFps(): String
}