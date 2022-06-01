package com.example.practicemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practicemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainviewModel: MainviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = QuotesDatabase.getDatabase(applicationContext).QuotesDaos()
        val repository = QuotesRepository(dao)
         mainviewModel = ViewModelProvider(this,ViewModelFactory(repository)).get(MainviewModel::class.java)


        mainviewModel.getQuotes().observe(this, Observer {
            binding.quote = it.toString()
        })

        binding.btnclickid.setOnClickListener {
            val quoteinsert = Quote(0,"this is about the quotes","sajib saha")
            mainviewModel.insertQuotes(quoteinsert)
        }

    }
}