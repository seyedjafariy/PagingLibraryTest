package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json

data class ProfileImage(
        @Json(name = "small") val small: String,
        @Json(name = "medium") val medium: String,
        @Json(name = "large") val large: String
)