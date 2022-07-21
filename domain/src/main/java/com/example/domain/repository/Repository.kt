package com.example.domain.repository

import com.example.domain.model.Channel
import com.example.domain.model.Social
import com.example.domain.model.SocialModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun fetchData()
    fun getSocialList(): Flow<List<Social>>
    fun getChannelList(): Flow<List<Channel>>
}