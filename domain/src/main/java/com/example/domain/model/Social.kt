package com.example.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Social(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @Json(name = "icon_url")
    val iconUrl: String? = "",
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "package_name_android")
    val packageNameAndroid: String? = "",
    @Json(name = "url")
    val url: String? = ""
)