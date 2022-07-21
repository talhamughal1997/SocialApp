package com.example.data.local

import com.example.data.db.AppDB
import com.example.domain.model.Channel
import com.example.domain.model.Social
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.distinctUntilChangedBy
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val appDB: AppDB) : LocalDataSource {
    override fun getSocialList() = appDB.socialDao().getSocial()

    override fun getChannelList() = appDB.channelDao().getChannel()

    override suspend fun insertSocialList(list: List<Social?>?) {
        appDB.socialDao().deleteSocialList()
        appDB.socialDao().insertSocial(list ?: emptyList())
    }

    override suspend fun insertChannelList(list: List<Channel?>?) {
        appDB.channelDao().deleteChannelList()
        appDB.channelDao().insertChannelList(list ?: emptyList())
    }


}