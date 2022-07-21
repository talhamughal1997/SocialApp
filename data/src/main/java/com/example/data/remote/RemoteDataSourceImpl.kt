package com.example.data.remote

import android.app.usage.NetworkStats
import com.example.data.network.ApiInterface
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val apiInterface: ApiInterface):RemoteDataSource {

    override suspend fun fetchData() = apiInterface.fetchData()

}