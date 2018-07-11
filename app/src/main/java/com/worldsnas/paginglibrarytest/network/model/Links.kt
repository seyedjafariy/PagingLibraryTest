package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json

data class Links(
    @Json(name = "self") val self: String,
    @Json(name = "html") val html: String,
    @Json(name = "download") val download: String,
    @Json(name = "download_location") val downloadLocation: String
)
