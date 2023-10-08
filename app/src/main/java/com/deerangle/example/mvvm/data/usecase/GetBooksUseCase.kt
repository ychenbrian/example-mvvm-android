package com.deerangle.example.mvvm.data.usecase

import com.deerangle.example.mvvm.data.model.domain.Book
import com.deerangle.example.mvvm.data.model.mapper.BookMapper
import com.deerangle.example.mvvm.data.repository.BookRepository
import com.deerangle.example.mvvm.utils.core.Response
import com.deerangle.example.mvvm.utils.helpers.NetworkHelper
import dagger.Reusable
import javax.inject.Inject

typealias GetBooksOutput = Response<List<Book>>

@Reusable
class GetBooksUseCase
    @Inject
    constructor(
        private val bookRepository: BookRepository,
        private val networkHelper: NetworkHelper,
    ) {
        suspend operator fun invoke(
            date: String,
            list: String,
        ): GetBooksOutput =
            if (networkHelper.isNetworkConnected()) {
                bookRepository.getBooks(date, list).let {
                    if (it.isSuccessful) {
                        val result: MutableList<Book> = mutableListOf()
                        it.body()?.results?.books?.let {
                            for (book in it) {
                                result.add(BookMapper().map(book))
                            }
                        }
                        Response.success(result)
                    } else {
                        Response.error(it.errorBody().toString(), null)
                    }
                }
            } else {
                Response.error("No internet connection", null)
            }
    }
