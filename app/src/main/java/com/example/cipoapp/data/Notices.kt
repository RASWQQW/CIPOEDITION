package com.example.cipoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="notices")
data class Notices(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    @ColumnInfo(name="count")
    var count : Int = 0,
)
