package com.davidmatillacode.common.composeui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.davidmatillacode.common.navigator.Screens
import com.davidmatillacode.common.composeui.proyectlist.ListScreen
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Composable
fun MainContent(){
    Scaffold {
        Column {
            Text("Texto scaffold")
        }
    }
    /*val router: Router<Screens> = rememberRouter(listOf(Screens.List))

    RoutedContent(
        router = router,
        animation = stackAnimation(slide()),
    ) { screen ->
        when (screen) {
            is List -> ListScreen(onSelect { detail -> router.push(detail) } )
            is Details -> DetailsScreen(screen.detail)
        }
    }*/
}