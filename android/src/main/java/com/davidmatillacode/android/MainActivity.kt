package com.davidmatillacode.android

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.davidmatillacode.common.composeui.utils.defaultTypography
import com.davidmatillacode.common.composeui.utils.primaryColor
import com.davidmatillacode.common.composeui.utils.secondaryColor
import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.di.getAppDI
import io.github.xxfast.decompose.LocalComponentContext
import org.kodein.di.instance
import kotlin.random.Random


class MainActivity: AppCompatActivity() {
    private val db: Database by getAppDI().instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getBaseDBInfo()
        val rootComponentContext: DefaultComponentContext = defaultComponentContext()
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        Log.d("DMATILLAA", "$height / $width")
        setContent {
            CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                MaterialTheme (typography = defaultTypography, colors = MaterialTheme.colors.copy(
                    primary =primaryColor, secondary = secondaryColor, background = Color.White)){
                    MainContent(width, height)
                }
            }
        }
    }


    fun getBaseDBInfo(){
        val db: Database by getAppDI().instance()
        for(x in 1..10){
            db.tagsSQLQueries.insertTag("Tag $x")
        }
        for(x in 1..10) {
            db.projectSQLQueries.insertProject("prueba project $x")
            for(y in 1..3) {
                db.projectTagsSQLQueries.insertProjectTags((Random.nextLong() % 20), x.toLong())
            }
            for(y in 1..10){
                db.taskSQLQueries.insertTask(x.toLong(), "project $x task $y",10)
            }
            val tasks = db.taskSQLQueries.selectTaskByFilters(x.toLong(),"").executeAsList()
            for(task in tasks) {
                for (z in 1..3) {
                    db.taskTagsSQLQueries.insertTaskTags(Random.nextLong(1,20), task.id_task)
                }
            }
        }
    }
}