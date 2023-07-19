package com.davidmatillacode.common.composeui.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

//NORMAL TEXT
@Composable
fun TextSmall(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeSmall, TextUnitType.Sp), fontFamily = defaultFont, modifier = modifier)
}

@Composable
fun TextMedium(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeMedium, TextUnitType.Sp), fontFamily = defaultFont, modifier = modifier)
}

@Composable
fun TextLarge(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeLarge, TextUnitType.Sp), fontFamily = defaultFont, modifier = modifier)
}


//BOLD TEXT
@Composable
fun TextSmallBold(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeSmall, TextUnitType.Sp), fontFamily = defaultFontBold, modifier = modifier)
}

@Composable
fun TextMediumBold(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeMedium, TextUnitType.Sp), fontFamily = defaultFontBold, modifier = modifier)
}

@Composable
fun TextLargeBold(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeLarge, TextUnitType.Sp), fontFamily = defaultFontBold, modifier = modifier)
}


//ITALIC TEXT
@Composable
fun TextSmallItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeSmall, TextUnitType.Sp), fontFamily = defaultFontItalic, modifier = modifier)
}

@Composable
fun TextMediumItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeMedium, TextUnitType.Sp), fontFamily = defaultFontItalic, modifier = modifier)
}

@Composable
fun TextLargeItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeLarge, TextUnitType.Sp), fontFamily = defaultFontItalic, modifier = modifier)
}


//ITALIC BOLD TEXT
@Composable
fun TextSmallBoldItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeSmall, TextUnitType.Sp), fontFamily = defaultFontBoldItalic, modifier = modifier)
}

@Composable
fun TextMediumBoldItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeMedium, TextUnitType.Sp), fontFamily = defaultFontBoldItalic, modifier = modifier)
}

@Composable
fun TextLargeBoldItalic(value: String,color : Color = textColor,modifier: Modifier = Modifier){
    Text(value,color = color, fontSize = TextUnit(textSizeLarge, TextUnitType.Sp), fontFamily = defaultFontBoldItalic, modifier = modifier)
}