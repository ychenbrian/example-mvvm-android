package com.deerangle.example.mvvm.data.model.api

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class ISBNModel(
    @field:Json(name = "isbn10") val isbn10: String?,
    @field:Json(name = "isbn13") val isbn13: String?,
)
