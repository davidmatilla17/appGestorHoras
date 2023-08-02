package com.davidmatillacode.common.utils

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skia.Image
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

fun bufferedToBitmap(img : BufferedImage?) : ImageBitmap? {
    if(img == null){
        return null
    }
    val stream = ByteArrayOutputStream()
    ImageIO.write(img, "png", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).asImageBitmap()
}