package com.example.gaditeksocialapp.di

import com.example.data.BuildConfig
import com.example.data.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @JvmStatic
    @Provides
    fun provideOkHttp() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    @JvmStatic
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()


    @JvmStatic
    @Provides
    fun provideApiInterface(retrofit: Retrofit) =
        retrofit.create(ApiInterface::class.java)

}