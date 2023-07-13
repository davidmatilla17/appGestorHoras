package com.davidmatillacode.common.navigator

import androidx.compose.runtime.Composable
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.davidmatillacode.common.composeui.proyectdetail.DetailScreen
import com.davidmatillacode.common.composeui.proyectlist.ListScreen
import io.github.xxfast.decompose.router.Router


@Parcelize
sealed class Screens : Parcelable {
    object List : Screens()
    data class Details(val text: String) : Screens()
}
@Composable
fun getScreen(type : Screens,router: Router<Screens>,width : Int, height : Int){
    when(type){
        is Screens.List -> ListScreen(router,width,height)
        is Screens.Details -> DetailScreen("",router,width, height)
    }
}