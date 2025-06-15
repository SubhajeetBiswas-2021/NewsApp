package com.subhajeet.newsapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {

    val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/").client(
        OkHttpClient.Builder().build()
    ).addConverterFactory(
        GsonConverterFactory.create()).build().create(
            ApiService::class.java)           //class::java it converts kotlin class to java as retrofit works in java

}
