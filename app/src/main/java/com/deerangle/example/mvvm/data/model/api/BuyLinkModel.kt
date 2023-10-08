package com.deerangle.example.mvvm.data.model.api

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class BuyLinkModel(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "url") val url: String?,
)
