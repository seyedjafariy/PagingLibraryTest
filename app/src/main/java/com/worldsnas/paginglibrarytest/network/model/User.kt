package com.worldsnas.paginglibrarytest.network.model

import com.squareup.moshi.Json

data class User(
        @Json(name = "id") val id: String,
        @Json(name = "updated_at") val updatedAt: String,
        @Json(name = "username") val username: String,
        @Json(name = "name") val name: String,
        @Json(name = "first_name") val firstName: String,
        @Json(name = "last_name") val lastName: String,
        @Json(name = "twitter_username") val twitterUsername: String,
        @Json(name = "portfolio_url") val portfolioUrl: String,
        @Json(name = "bio") val bio: String,
        @Json(name = "location") val location: String,
        @Json(name = "links") val links: UserLinks,
        @Json(name = "profile_image") val profileImage: ProfileImage,
        @Json(name = "instagram_username") val instagramUsername: String,
        @Json(name = "total_collections") val totalCollections: Int,
        @Json(name = "total_likes") val totalLikes: Int,
        @Json(name = "total_photos") val totalPhotos: Int
)