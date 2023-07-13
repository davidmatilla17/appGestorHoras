package com.davidmatillacode.android

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.davidmatillacode.common.db.DriverFactory
import com.davidmatillacode.common.db.createDatabase
import io.github.xxfast.decompose.LocalComponentContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponentContext: DefaultComponentContext = defaultComponentContext()
        val displayMetrics = DisplayMetrics()
        val database = createDatabase(DriverFactory(this))
        database.projectSQLQueries.insertProject("prueba")
        val query =database.projectSQLQueries.selectAll().executeAsList()
        Log.d("dmatillaaaaa","qqqqyeryyy ${query}")
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        Log.d("DMATILLAA", "$height / $width")
        setContent {
            CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                MaterialTheme {
                    MainContent(width,height)
                }
            }
        }
    }
}