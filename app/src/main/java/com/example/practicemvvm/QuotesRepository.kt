package com.example.practicemvvm

import androidx.lifecycle.LiveData

class QuotesRepository(private val quoteDAO: QuoteDAO) {


    fun getQuotes():LiveData<List<Quote>>{
        return quoteDAO.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote){
        return quoteDAO.insertQuotes(quote)
    }

}