package com.example.herboshadhi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val rf = Retrofit.Builder()
        .baseUrl(RetrofitInterface.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


interface RetrofitInterface {

    @get:GET("posts?_embed")
    val posts : Call<List<PostModel?>?>?

    @get:GET("posts?_embed&categories=46")
    val posts_ayurved_sidhant: Call<List<PostModel?>?>?

    companion object {
        const val BASE_URL = "https://herboshadhi.com/wp-json/wp/v2/"
    }
}

