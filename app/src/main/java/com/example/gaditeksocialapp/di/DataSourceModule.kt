package com.example.gaditeksocialapp.di

import com.example.data.local.LocalDataSource
import com.example.data.local.LocalDataSourceImpl
import com.example.data.remote.RemoteDataSource
import com.example.data.remote.RemoteDataSourceImpl
import com.example.data.repository.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Singleton
    @Binds
    abstract fun provideRepository(repository: RepositoryImpl): Repository


}