package com.example.domain.usecase.main.channel_list

import com.example.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetChannelListUC @Inject constructor(private val repository: Repository) {
     operator fun invoke() = repository.getChannelList()
}