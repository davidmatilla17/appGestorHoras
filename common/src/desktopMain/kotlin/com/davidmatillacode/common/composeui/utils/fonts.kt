package com.davidmatillacode.common.composeui.utils

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType


//DEFAULT FONT
actual val defaultFont =  FontFamily(
    Font("fonts/Poppins/Poppins-Regular.ttf")
)
actual val defaultFontItalic =  FontFamily(
    Font("fonts/Poppins/Poppins-Italic.ttf")
)
actual val defaultFontBold =  FontFamily(
    Font("fonts/Poppins/Poppins-Bold.ttf")
)
actual val defaultFontBoldItalic =  FontFamily(
    Font("fonts/Poppins/Poppins-BoldItalic.ttf")
)

val defaultTextStyle = TextStyle(color = textColor,
                                fontSize = TextUnit(textSizeMedium, TextUnitType.Sp,),
                                fontFamily = defaultFont)

actual val defaultTypography = Typography(defaultFont, h1=defaultTextStyle,
h2=defaultTextStyle,
h3=defaultTextStyle,
h4=defaultTextStyle,
h5=defaultTextStyle,
h6=defaultTextStyle,
subtitle1=defaultTextStyle,
subtitle2=defaultTextStyle,
body1=defaultTextStyle,
body2=defaultTextStyle,
button=defaultTextStyle,
caption= defaultTextStyle,
overline=defaultTextStyle)