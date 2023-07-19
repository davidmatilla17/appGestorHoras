package com.davidmatillacode.common.composeui.utils

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.davidmatillacode.common.R

actual val defaultFont =  FontFamily(
    Font(resId = R.font.poppins_regular)
)
actual val defaultFontItalic =  FontFamily(
    Font(resId = R.font.poppins_italic)
)
actual val defaultFontBold =  FontFamily(
    Font(resId = R.font.poppins_bold)
)
actual val defaultFontBoldItalic =  FontFamily(
    Font(resId = R.font.poppins_bold_italic)
)
actual val defaultTypography: Typography = Typography(defaultFont)