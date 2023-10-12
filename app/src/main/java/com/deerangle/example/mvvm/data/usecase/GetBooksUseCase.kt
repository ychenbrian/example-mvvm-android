package com.deerangle.example.mvvm.data.usecase

import com.deerangle.example.mvvm.R
import com.deerangle.example.mvvm.data.model.domain.Book
import com.deerangle.example.mvvm.data.model.mapper.BookMapper
import com.deerangle.example.mvvm.data.repository.BookRepository
import com.deerangle.example.mvvm.utils.core.Response
import com.deerangle.example.mvvm.utils.helper.NetworkHelper
import com.deerangle.example.mvvm.utils.helper.ResourceProvider
import dagger.Reusable
import javax.inject.Inject

typealias GetBooksOutput = Response<List<Book>>

@Reusable
class GetBooksUseCase
    @Inject
    constructor(
        private val bookRepository: BookRepository,
        private val networkHelper: NetworkHelper,
        private val resourceProvider: ResourceProvider,
    ) {
        suspend operator fun invoke(
            date: String,
            list: String,
        ): GetBooksOutput =
            if (networkHelper.isNetworkConnected()) {
                bookRepository.getBooks(date, list).let { response ->
                    if (response.isSuccessful) {
                        val result: MutableList<Book> = mutableListOf()
                        response.body()?.results?.books?.let { books ->
                            for (book in books) {
                                result.add(BookMapper().map(book))
                            }
                        }
                        Response.success(result)
                    } else {
                        Response.error(response.errorBody().toString(), null)
                    }
                }
            } else {
                Response.error(resourceProvider.getString(R.string.no_internet_connection), null)
            }
    }
