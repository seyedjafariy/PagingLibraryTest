package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json

data class UserLinks(
        @Json(name = "self") val self: String,
        @Json(name = "html") val html: String,
        @Json(name = "photos") val photos: String,
        @Json(name = "likes") val likes: String,
        @Json(name = "portfolio") val portfolio: String,
        @Json(name = "following") val following: String,
        @Json(name = "followers") val followers: String
)