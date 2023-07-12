package com.davidmatillacode.common.app

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize


@Parcelize
sealed class Screen : Parcelable {
    object List : Screen()
    data class Details(val text: String) : Screen()
}