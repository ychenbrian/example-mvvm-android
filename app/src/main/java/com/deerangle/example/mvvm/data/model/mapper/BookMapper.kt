package com.deerangle.example.mvvm.data.model.mapper

import com.deerangle.example.mvvm.data.model.api.BookModel
import com.deerangle.example.mvvm.data.model.domain.Book

class BookMapper : Mapper<BookModel, Book> {
    override fun map(input: BookModel): Book {
        return Book(
            id = input.primaryIsbn13,
            rank = input.rank,
            title = input.title,
            author = input.author,
            description = input.description,
            contributor = input.contributor,
            bookImage = input.bookImage,
            bookReviewLink = input.bookReviewLink,
            firstChapterLink = input.firstChapterLink,
            sundayReviewLink = input.sundayReviewLink,
            articleChapterLink = input.articleChapterLink,
            bookUri = input.bookUri,
            amazonProductUrl = input.amazonProductUrl,
        )
    }
}
