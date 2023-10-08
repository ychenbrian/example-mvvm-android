package com.deerangle.example.mvvm.data.model.api

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class BookMetaModel(
    @field:Json(name = "status") val status: String?,
    @field:Json(name = "copyright") val copyright: String?,
    @field:Json(name = "num_results") val numResults: Int?,
    @field:Json(name = "last_modified") val lastModified: String?,
    @field:Json(name = "results") val results: BookResultModel?,
)
