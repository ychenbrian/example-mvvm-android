package com.deerangle.example.mvvm.ui.home.homemain

import com.airbnb.epoxy.TypedEpoxyController
import com.deerangle.example.mvvm.bookCard
import com.deerangle.example.mvvm.data.model.domain.Book
import com.deerangle.example.mvvm.data.model.epoxy.BookCardData

class HomeMainController : TypedEpoxyController<List<Book>>() {
    override fun buildModels(data: List<Book>?) {
        data?.forEach { book ->
            bookCard {
                id(book.id)
                data(
                    BookCardData(
                        title = book.title,
                        author = book.author,
                        bookImage = book.bookImage,
                        rank = book.rank.toString(),
                    ),
                )
            }
        }
    }
}
