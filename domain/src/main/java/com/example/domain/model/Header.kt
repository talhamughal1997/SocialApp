package com.example.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Header(
    @Json(name = "code")
    val code: Int? = 0,
    @Json(name = "message")
    val message: String? = ""
)