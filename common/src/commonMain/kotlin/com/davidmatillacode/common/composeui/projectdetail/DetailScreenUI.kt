package com.davidmatillacode.common.composeui.projectdetail

import androidx.compose.runtime.Composable
import com.davidmatillacode.common.navigator.Screens
import io.github.xxfast.decompose.router.Router


@Composable
expect fun DetailScreen(id : Long,
                 router: Router<Screens>,
                 width : Int, height : Int)