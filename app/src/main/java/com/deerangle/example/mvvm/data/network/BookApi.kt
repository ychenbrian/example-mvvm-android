package com.deerangle.example.mvvm.data.network

import com.deerangle.example.mvvm.BuildConfig
import com.deerangle.example.mvvm.data.model.api.BookMetaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApi {
    @GET("lists/{date}/{list}.json")
    suspend fun getBooks(
        @Path("date") date: String?,
        @Path("list") list: String?,
        @Query("api-key") apiKey: String = BuildConfig.NYT_API_KEY,
    ): Response<BookMetaModel>
}
