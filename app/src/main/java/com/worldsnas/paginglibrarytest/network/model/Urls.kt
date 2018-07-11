package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json

data class Urls (
        @Json(name = "raw") val raw: String,
        @Json(name = "full") val full: String,
        @Json(name = "regular") val regular: String,
        @Json(name = "small") val small: String,
        @Json(name = "thumb") val thumb: String
)