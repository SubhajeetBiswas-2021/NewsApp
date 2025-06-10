package com.subhajeet.newsapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.subhajeet.newsapp.viewModels.NewsViewModels


@Composable
fun HomeScreen(viewModels : NewsViewModels){

    val res = viewModels.res.value?.articles ?: emptyList()


    Column {

        LazyColumn {
            items(res){

                Text(text=it.title)
            }

        }
    }
}
