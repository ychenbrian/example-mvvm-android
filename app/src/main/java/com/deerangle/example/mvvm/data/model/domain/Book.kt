package com.deerangle.example.mvvm.data.model.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val id: String?,
    val rank: Int?,
    val title: String?,
    val author: String?,
    val description: String?,
    val contributor: String?,
    val bookImage: String?,
    val bookReviewLink: String?,
    val firstChapterLink: String?,
    val sundayReviewLink: String?,
    val articleChapterLink: String?,
    val bookUri: String?,
    val amazonProductUrl: String?,
) : Parcelable
