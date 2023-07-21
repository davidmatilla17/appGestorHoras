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
import com.davidmatillacode.common.di.RepositoryModule
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.di.viewModelModule
import di.dbModule
import io.github.xxfast.decompose.LocalComponentContext
import org.kodein.di.DI
import org.kodein.di.instance
import utils.runOnUiThread
import kotlin.random.Random

val di = DI {
    import(viewModelModule)
    import(RepositoryModule)
    importAll(dbModule)
}

private
fun main() {
    BaseDI.di = di
    getBaseDBInfo()
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = runOnUiThread {  DefaultComponentContext(lifecycle = lifecycle) }
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

fun getBaseDBInfo(){
    val db: Database by getAppDI().instance()
    for(x in 1..10){
        db.tagsSQLQueries.insertTag("Tag $x")
    }
    for(x in 1..10) {
        db.projectSQLQueries.insertProject("prueba project $x")
        for(y in 1..3) {
            db.projectTagsSQLQueries.insertProjectTags((Random.nextLong() % 20), x.toLong())
        }
        for(y in 1..10){
            db.taskSQLQueries.insertTask(x.toLong(), "project $x task $y",10)
        }
        val tasks = db.taskSQLQueries.selectTaskByFilters(x.toLong(),"").executeAsList()
        for(task in tasks) {
            for (z in 1..3) {
                db.taskTagsSQLQueries.insertTaskTags(Random.nextLong(1,20), task.id_task)
            }
        }
    }
}