package com.davidmatillacode.common.composeui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.router.stack.pop
import com.davidmatillacode.common.composeui.utils.TextMediumBold
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.navigator.Screens
import com.davidmatillacode.common.utils.bufferedToBitmap
import com.davidmatillacode.common.viewmodel.CameraViewModel
import io.github.xxfast.decompose.router.Router
import org.kodein.di.instance
import javax.swing.ImageIcon

@Suppress("SuspiciousIndentation")
@Composable
fun CameraScreen(
    id: Long,
    router: Router<Screens>,
    width: Int, height: Int
) {
    val cameraViewModel by getAppDI().instance<CameraViewModel>()

    val image = bufferedToBitmap(cameraViewModel.imageState.value)
    Scaffold {
        Box(Modifier.fillMaxSize()) {
            if (image != null) {
                Image(image, "texto", modifier = Modifier.width(1320.dp).height(720.dp))
            }
            Column {
                TextMediumBold(cameraViewModel.getFps())
                IconButton(onClick = {
                    cameraViewModel.switchCamera()
                }){
                    if(cameraViewModel.isOpenCamera()) {
                        Icon(Icons.Default.Close, "text")
                    }else{
                        Icon(Icons.Default.PlayArrow, "text")

                    }
                }
            }
        }

    }
}