package com.davidmatillacode.common.viewmodel

import ViewModel

actual class CameraViewModel : ViewModel() {
    actual fun switchCamera() {
    }

    actual fun isOpenCamera(): Boolean {

       return true
    }

    actual fun getFps(): String {
       return ""
    }

}