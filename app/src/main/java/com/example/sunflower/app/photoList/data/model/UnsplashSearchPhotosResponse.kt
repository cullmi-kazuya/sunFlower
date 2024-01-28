package com.example.sunflower.app.photoList.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashSearchPhotosResponse(
    @Json(name = "total") val total: Int,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "results") val results: List<Photo>
)

@JsonClass(generateAdapter = true)
data class Photo(
    @Json(name = "id") val id: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "width") val width: Int,
    @Json(name = "height") val height: Int,
    @Json(name = "color") val color: String,
    @Json(name = "blur_hash") val blurHash: String,
    @Json(name = "likes") val likes: Int,
    @Json(name = "liked_by_user") val likedByUser: Boolean,
    @Json(name = "description") val description: String?,
    @Json(name = "user") val user: User,
    @Json(name = "current_user_collections") val currentUserCollections: List<Any>,
    @Json(name = "urls") val urls: Urls,
    @Json(name = "links") val links: Links
)

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: String,
    @Json(name = "username") val username: String,
    @Json(name = "name") val name: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "instagram_username") val instagramUsername: String,
    @Json(name = "twitter_username") val twitterUsername: String,
    @Json(name = "portfolio_url") val portfolioUrl: String?,
    @Json(name = "profile_image") val profileImage: ProfileImage,
    @Json(name = "links") val links: UserLinks
)

@JsonClass(generateAdapter = true)
data class Urls(
    @Json(name = "raw") val raw: String,
    @Json(name = "full") val full: String,
    @Json(name = "regular") val regular: String,
    @Json(name = "small") val small: String,
    @Json(name = "thumb") val thumb: String
)

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "self") val self: String,
    @Json(name = "html") val html: String,
    @Json(name = "download") val download: String
)

@JsonClass(generateAdapter = true)
data class ProfileImage(
    @Json(name = "small") val small: String,
    @Json(name = "medium") val medium: String,
    @Json(name = "large") val large: String
)

@JsonClass(generateAdapter = true)
data class UserLinks(
    @Json(name = "self") val self: String,
    @Json(name = "html") val html: String,
    @Json(name = "photos") val photos: String,
    @Json(name = "likes") val likes: String
)

