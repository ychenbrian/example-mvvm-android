package com.deerangle.example.mvvm.data.model.api

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class BookResultModel(
    @field:Json(name = "list_name") val listName: String?,
    @field:Json(name = "list_name_encoded") val listNameEncoded: String?,
    @field:Json(name = "bestsellers_date") val bestsellersEate: String?,
    @field:Json(name = "published_date") val publishedDate: String?,
    @field:Json(name = "published_date_description") val publishedDateDescription: String?,
    @field:Json(name = "next_published_date") val nextPublishedDate: String?,
    @field:Json(name = "previous_published_date") val previousPublishedDate: String?,
    @field:Json(name = "display_name") val displayName: String?,
    @field:Json(name = "normal_list_ends_at") val normalListEndsAt: Int?,
    @field:Json(name = "updated") val updated: String?,
    @field:Json(name = "books") val books: List<BookModel>?,
)
