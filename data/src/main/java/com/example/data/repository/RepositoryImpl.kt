package com.example.data.repository

import com.example.data.local.LocalDataSource
import com.example.data.remote.RemoteDataSource
import com.example.domain.model.Channel
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
) : Repository {

    override suspend fun fetchData() = try {
        val social = remoteDataSource.fetchData()
        localDataSource.insertChannelList(social.body?.channels)
        localDataSource.insertSocialList(social.body?.socials)
    } catch (e: Exception) {

    }

    override fun getSocialList() = localDataSource.getSocialList()


    override fun getChannelList(): Flow<List<Channel>> = localDataSource.getChannelList()
}