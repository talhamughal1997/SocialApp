package com.example.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class SocialModel(
    @Json(name = "body")
    val body: Body? = Body(),
    @Json(name = "header")
    val header: Header? = Header()
)