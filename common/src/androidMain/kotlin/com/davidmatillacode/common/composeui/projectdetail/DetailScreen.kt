package com.davidmatillacode.common.composeui.projectdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.di.getAppDI
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router
import org.kodein.di.instance

@Composable
actual fun DetailScreen(
    id: Long,
    router: Router<Screens>,
    width: Int,
    height: Int
) {
    val db : Database by getAppDI().instance()
    val p = db.projectSQLQueries.selectById(id).executeAsOneOrNull()
    Scaffold {
        Column {
            IconButton(onClick = {
                router.pop()
            }){
                Icon(Icons.Default.ArrowBack,"")
            }
            Text("esto es un texto Detalle ${p?.id_project}")
            TextButton(onClick = {
                if(p != null) {
                    router.push(Screens.Details(id+1))
                }
            }){
                Text("boton")
            } }

    }
}