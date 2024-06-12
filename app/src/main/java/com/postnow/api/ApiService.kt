package com.postnow.api

import com.postnow.model.PostEntity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("postnow/get/posts")
    fun getPosts(): Call<List<PostEntity>>


    @POST("postnow/post")
    fun postPosts(@Body postEntity: PostEntity): Call<ResponseBody>
}
