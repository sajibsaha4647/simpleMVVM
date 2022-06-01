package com.example.practicemvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class],version = 1)
abstract class QuotesDatabase :RoomDatabase() {
   abstract fun QuotesDaos():QuoteDAO

   companion object{
       private var INSTANCE : QuotesDatabase? = null

            fun getDatabase(context:Context) :QuotesDatabase{
                if (INSTANCE == null){
                    synchronized(this){
                        INSTANCE = Room.databaseBuilder(context,QuotesDatabase::class.java,"quotesname.db")
                            .createFromAsset("quotes.db")
                            .build()
                    }
                }
                return INSTANCE!!
            }
   }

}