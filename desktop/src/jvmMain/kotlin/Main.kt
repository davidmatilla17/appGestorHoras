import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.davidmatillacode.common.composeui.utils.defaultTypography
import com.davidmatillacode.common.composeui.utils.primaryColor
import com.davidmatillacode.common.composeui.utils.secondaryColor
import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.di.BaseDI
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.di.viewModelModule
import di.dbModule
import io.github.xxfast.decompose.LocalComponentContext
import org.kodein.di.DI
import org.kodein.di.instance

val di = DI {
    import(viewModelModule)
    importAll(dbModule)
}

private
fun main() {
    BaseDI.di = di
    val db: Database by getAppDI().instance()
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle = lifecycle)
    for(x in 1..10)
        db.projectSQLQueries.insertProject("prueba")
    application {
        val windowState = rememberWindowState(size = DpSize(1320.dp,720.dp))
        LifecycleController(lifecycle, windowState)
        println("${windowState.size.height} / ${windowState.size.width}")
        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Compose Navigator Example"
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                MaterialTheme (typography = defaultTypography, colors = MaterialTheme.colors.copy(
                    primary = primaryColor, secondary = secondaryColor, background = Color.White
                )){
                    CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                        MainContent(windowState)
                    }
                }
            }
        }
    }
}