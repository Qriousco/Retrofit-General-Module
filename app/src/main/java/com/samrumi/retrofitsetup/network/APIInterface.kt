package com.samrumi.retrofitsetup.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/api/users")
    fun getPosts(@Query("page") page: String): Call<Any>
}