package com.example.data.remote

import com.example.domain.model.SocialModel

interface RemoteDataSource {
    suspend fun fetchData():SocialModel
}