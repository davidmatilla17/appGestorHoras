package com.davidmatillacode.common.composeui.utils

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

//COLORS
val primaryColor = Color(38, 60, 122)
val accentColor = Color(102, 182, 255)
val secondaryColor = Color(102, 182, 255)
val grayLight = Color(232, 231, 230)
val textColor = Color(22, 33, 47)
val textHintColor = Color(150, 150, 150)
val backgroundLight = Color(232, 232, 232)


//TEXT SIZE
val textSizeLarge = 24f
val textSizeMedium = 14f
val textSizeSmall = 12f

//PADDINGS
val paddingLarge = 24.dp
val paddingMedium = 16.dp
val paddingSmall = 12.dp
val paddingMinimun = 4.dp

//DEFAULT FONT
expect val defaultFont :FontFamily
expect val defaultFontItalic :FontFamily
expect val defaultFontBold :FontFamily
expect val defaultFontBoldItalic :FontFamily

expect val defaultTypography :Typography