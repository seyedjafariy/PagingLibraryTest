package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json
import io.reactivex.annotations.Nullable

data class Photo(
    @Json(name = "id") val id: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "width") val width: Int,
    @Json(name = "height") val height: Int,
    @Json(name = "color") val color: String,
    @Json(name = "description") val description: String,
    @Json(name = "urls") val urls: Urls,
    @Json(name = "links") val links: Links,
    @Json(name = "categories") val categories: List<String>,
    @Json(name = "sponsored") val sponsored: Boolean,
    @Json(name = "likes") val likes: Int,
    @Json(name = "liked_by_user") val likedByUser: Boolean,
    @Json(name = "current_user_collections") val currentUserCollections: List<String>,
    @Json(name = "slug") val slug: String?,
    @Json(name = "user") val user: User
)





