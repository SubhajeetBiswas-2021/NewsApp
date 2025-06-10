package com.subhajeet.newsapp.repo

import com.subhajeet.newsapp.network.NewsModel
import com.subhajeet.newsapp.network.RetrofitClint
import retrofit2.Response

class Repo {

    suspend fun fetchNewsFromApi():Response<NewsModel> {
        return RetrofitClint.retrofit.getTopHeadlines()
    }
}