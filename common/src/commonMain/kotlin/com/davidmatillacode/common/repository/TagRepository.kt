package com.davidmatillacode.common.repository

import com.davidmatillacode.common.db.Database

class TagRepository(private val db: Database)  {

    suspend fun createTag(tag : String){
        db.tagsSQLQueries.insertTag(tag)
    }
}