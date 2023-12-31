import androidx.compose.runtime.Composable
import androidx.compose.ui.window.WindowState
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.davidmatillacode.common.composeui.CameraScreen
import com.davidmatillacode.common.navigator.Screens
import com.davidmatillacode.common.navigator.getScreen
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Composable
fun MainContent(windowState : WindowState){
    val router: Router<Screens> = rememberRouter(Screens::class,listOf(Screens.List))

    RoutedContent(
        router = router,
        animation = stackAnimation(slide()),
    ) { screen -> getScreen(screen, router,windowState.size.width.value.toInt(),windowState.size.height.value.toInt())
    }
}