package com.example.practicemvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainviewModel(private val quotesRepository: QuotesRepository):ViewModel() {

    fun getQuotes():LiveData<List<Quote>>{
            return quotesRepository.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote){
        viewModelScope.launch(Dispatchers.IO){
            quotesRepository.insertQuotes(quote)
        }
    }

}