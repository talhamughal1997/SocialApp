package com.example.data.network

import com.example.domain.model.SocialModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("android/premium/channels-socials.json")
    suspend fun fetchData():SocialModel
}