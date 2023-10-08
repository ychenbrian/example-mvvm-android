package com.deerangle.example.mvvm.data.repository

import com.deerangle.example.mvvm.data.network.ApiHelper
import javax.inject.Inject

class BookRepository
    @Inject
    constructor(private val apiHelper: ApiHelper) {
        suspend fun getBooks(
            date: String? = null,
            list: String? = null,
        ) = apiHelper.getBooks(date, list)
    }
