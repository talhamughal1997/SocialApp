package com.example.domain.usecase.main

import com.example.domain.repository.Repository
import javax.inject.Inject

class FetchDataUC @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() = repository.fetchData()
}