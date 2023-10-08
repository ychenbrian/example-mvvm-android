package com.deerangle.example.mvvm.data.model.api

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class BookModel(
    @field:Json(name = "rank") val rank: Int?,
    @field:Json(name = "rank_last_week") val rankLastWeek: Int?,
    @field:Json(name = "weeks_on_list") val weeksOnList: Int?,
    @field:Json(name = "asterisk") val asterisk: Int?,
    @field:Json(name = "dagger") val dagger: Int?,
    @field:Json(name = "primary_isbn10") val primaryIsbn10: String?,
    @field:Json(name = "primary_isbn13") val primaryIsbn13: String?,
    @field:Json(name = "publisher") val publisher: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "price") val price: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "author") val author: String?,
    @field:Json(name = "contributor") val contributor: String?,
    @field:Json(name = "contributor_note") val contributorNote: String?,
    @field:Json(name = "book_image") val bookImage: String?,
    @field:Json(name = "book_image_width") val bookImageWidth: Int?,
    @field:Json(name = "book_image_height") val bookImageHeight: Int?,
    @field:Json(name = "amazon_product_url") val amazonProductUrl: String?,
    @field:Json(name = "age_group") val ageGroup: String?,
    @field:Json(name = "book_review_link") val bookReviewLink: String?,
    @field:Json(name = "first_chapter_link") val firstChapterLink: String?,
    @field:Json(name = "sunday_review_link") val sundayReviewLink: String?,
    @field:Json(name = "article_chapter_link") val articleChapterLink: String?,
    @field:Json(name = "isbns") val isbns: List<ISBNModel>?,
    @field:Json(name = "buy_links") val buyLinks: List<BuyLinkModel>?,
    @field:Json(name = "book_uri") val bookUri: String?,
)
