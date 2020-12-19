package com.example.herboshadhi

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("posts?_embed")
    suspend fun posts() : Response<MutableList<PostModel>>

    @GET("posts?_embed&categories=46")
    suspend fun posts_ayurved_sidhant(): Response<MutableList<PostModel>>

    @GET("posts?_embed&categories=47")
    suspend fun posts_gharelu_upchar(): Response<MutableList<PostModel>>

    @GET("posts?_embed&categories=52")
    suspend fun posts_jyotishi(): Response<MutableList<PostModel>>

    @GET("posts?_embed&categories=48")
    suspend fun posts_yog(): Response<MutableList<PostModel>>

    @GET("posts?_embed&categories=49")
    suspend fun posts_sondarya(): Response<MutableList<PostModel>>

    @GET("posts/{ID}")
    suspend fun post_get_contents(@Path("ID") ID: Int): Response<PostModel>

}



