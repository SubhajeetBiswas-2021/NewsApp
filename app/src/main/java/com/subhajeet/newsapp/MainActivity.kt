package com.subhajeet.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.subhajeet.newsapp.screen.HomeScreen
import com.subhajeet.newsapp.ui.theme.NewsAppTheme
import com.subhajeet.newsapp.viewModels.NewsViewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModels : NewsViewModels by viewModels()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    HomeScreen(viewModels = viewModels)

              /*      GlobalScope.launch {
                   //     val checkApi = RetrofitClint.retrofit.getTopHeadlines().body()

                    //    Log.d("mydata",checkApi.toString())

                    val data = fetchData()

                    Log.d("data",data)
                    }         */

                    /*lifecycleScope.launch(Dispatchers.IO) {
                        Log.d("scope", Thread.currentThread().name)
                    }*/
                }
            }
        }
    }


}

