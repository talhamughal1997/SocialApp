package com.example.domain.usecase.main.social_list

import com.example.domain.repository.Repository
import javax.inject.Inject

class GetSocialListUC @Inject constructor(private val repository: Repository) {
     operator fun invoke() = repository.getSocialList()
}