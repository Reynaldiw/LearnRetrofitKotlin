package com.reynaldiwijaya.learnretrofitkotlin.Network

import com.reynaldiwijaya.learnretrofitkotlin.Model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostServices {

    @GET("posts")
    fun getPost(): Call<List<PostModel>>
}