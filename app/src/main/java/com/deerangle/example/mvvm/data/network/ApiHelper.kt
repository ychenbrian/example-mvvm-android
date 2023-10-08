package com.deerangle.example.mvvm.data.network

import com.deerangle.example.mvvm.data.model.api.BookMetaModel
import retrofit2.Response
import javax.inject.Inject

interface ApiHelper {
    suspend fun getBooks(
        date: String?,
        list: String?,
    ): Response<BookMetaModel>
}

class ApiHelperImpl
    @Inject
    constructor(private val bookApi: BookApi) : ApiHelper {
        override suspend fun getBooks(
            date: String?,
            list: String?,
        ): Response<BookMetaModel> = bookApi.getBooks(date, list)
    }
