package com.example.data.local

import com.example.domain.model.Channel
import com.example.domain.model.Social
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getSocialList(): Flow<List<Social>>
    fun getChannelList(): Flow<List<Channel>>
    suspend fun insertSocialList(list: List<Social?>?)
    suspend fun insertChannelList(list: List<Channel?>?)
}