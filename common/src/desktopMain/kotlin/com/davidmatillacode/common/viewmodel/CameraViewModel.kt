package com.davidmatillacode.common.viewmodel

import ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.github.sarxos.webcam.Webcam
import com.github.sarxos.webcam.WebcamEvent
import com.github.sarxos.webcam.WebcamListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.awt.Dimension
import java.awt.image.BufferedImage

actual class CameraViewModel : ViewModel() {
    private val _imageState = mutableStateOf<BufferedImage?>(null)
    private val webcam = Webcam.getDefault()
    val imageState  : State<BufferedImage?> =_imageState
    init {
        val d = Dimension(500,500)
        webcam.setCustomViewSizes(d)
        webcam.viewSize = d
        webcam.addWebcamListener(object  : WebcamListener {
            override fun webcamOpen(we: WebcamEvent?) {
                if(we != null)
                    _imageState.value = we.image
            }

            override fun webcamClosed(we: WebcamEvent?) {
            }

            override fun webcamDisposed(we: WebcamEvent?) {
            }

            override fun webcamImageObtained(we: WebcamEvent?) {
                if(we != null)
                    _imageState.value  = we.image
            }

        })
    }
    actual fun switchCamera() {
        launch(Dispatchers.IO) {
            if(webcam.isOpen){
                webcam.close()
            }else{
                webcam.open(true)
            }
        }
    }

    actual fun isOpenCamera(): Boolean {
        return webcam.isOpen
    }

    actual fun getFps(): String {
        if (!webcam.isOpen)
            return "0.0"
        return webcam.fps.toInt().toString()
    }

}