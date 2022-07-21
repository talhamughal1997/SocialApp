package com.example.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Body(
    @Json(name = "channels")
    val channels: List<Channel> = listOf(),
    @Json(name = "socials")
    val socials: List<Social> = listOf()
)