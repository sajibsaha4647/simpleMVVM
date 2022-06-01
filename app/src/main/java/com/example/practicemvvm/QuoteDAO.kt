package com.example.practicemvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDAO {

    @Query("SELECT * FROM quote")
    fun getQuotes():LiveData<List<Quote>>

    @Insert
    suspend fun insertQuotes(quote: Quote)
}