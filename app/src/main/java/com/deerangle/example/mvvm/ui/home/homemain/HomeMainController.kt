package com.deerangle.example.mvvm.ui.home.homemain

import com.airbnb.epoxy.TypedEpoxyController
import com.deerangle.example.mvvm.bookCard
import com.deerangle.example.mvvm.data.model.domain.Book

class HomeMainController : TypedEpoxyController<List<Book>>() {
    override fun buildModels(data: List<Book>?) {
        data?.forEach { book ->
            bookCard {
                id(book.id)
                title(book.title)
                author(book.author)
                image(book.bookImage)
            }
        }
    }
}
