package com.davidmatillacode.common.composeui.projectlist

import androidx.compose.runtime.Composable
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router

@Composable
 expect fun ListScreen(router: Router<Screens>,width : Int, height : Int)