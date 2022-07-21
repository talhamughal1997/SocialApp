package com.example.gaditeksocialapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.AppDB
import com.example.gaditeksocialapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): AppDB =
        Room.databaseBuilder(
            context,
            AppDB::class.java,
            Constant.DB_NAME
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

}