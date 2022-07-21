package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.ChannelDao
import com.example.data.db.dao.SocialDao
import com.example.domain.model.Channel
import com.example.domain.model.Social

@Database(entities = [Social::class,Channel::class],exportSchema = false,version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun socialDao(): SocialDao
    abstract fun channelDao(): ChannelDao
}