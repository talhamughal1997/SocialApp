package com.example.data.db.dao

import androidx.room.*
import com.example.domain.model.Channel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {
    @Query("SELECT * from Channel")
    fun getChannel(): Flow<List<Channel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChannelList(channels: List<Channel?>)

    @Query("DELETE FROM Channel")
    suspend fun deleteChannelList()
}