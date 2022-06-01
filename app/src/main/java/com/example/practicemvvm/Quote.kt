package com.example.practicemvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val text:String,
    val author:String
)
