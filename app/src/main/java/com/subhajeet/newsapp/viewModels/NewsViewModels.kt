package com.subhajeet.newsapp.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhajeet.newsapp.network.NewsModel
import com.subhajeet.newsapp.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModels():ViewModel() {
    val res = mutableStateOf<NewsModel?>(null)  //Making a state of the data we will be getting,mutable state means a state whose value we can change

    val repo = Repo()  //Making instance/object of Repo()

    //value that will come from repo will be passed to res

    init {
        fetchData()
    }

    fun fetchData(){

       viewModelScope.launch(Dispatchers.IO) {
           res.value = repo.fetchNewsFromApi().body()  //we had wrote it under viewModelScope as without it the fetchNewsFromApi will not work as it is suspend one
           //response =  data   (data will come with repo.fetchNewsFromApi().body())
       }
    }
}