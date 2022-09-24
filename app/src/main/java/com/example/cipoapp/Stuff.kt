package com.example.cipoapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


//table name with you want create
@Entity(tableName = "link_story")
data class Stuff (
//    auto
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo(name = "links")
    var links: String,

    @ColumnInfo(name = "date")
    var date : Date,
        )