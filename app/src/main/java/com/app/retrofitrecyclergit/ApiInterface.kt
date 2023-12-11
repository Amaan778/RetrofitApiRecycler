package com.app.retrofitrecyclergit

import com.app.newsappcreate.modelclassfir.Newslistch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v2/top-headlines")
    fun getNews(
        @Query("apikey") apiKey: String,
//        @Query("q") query: String,
//        @Query("language") language: String
        @Query("country") country:String,
        @Query("category") category:String
    ): Call<Newslistch>
}