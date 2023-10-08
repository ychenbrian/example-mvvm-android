package com.deerangle.example.mvvm.ui.home.homemain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deerangle.example.mvvm.data.model.domain.Book
import com.deerangle.example.mvvm.data.usecase.GetBooksUseCase
import com.deerangle.example.mvvm.utils.core.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMainViewModel
    @Inject
    constructor(
        private val getBooksUseCase: GetBooksUseCase,
    ) : ViewModel() {
        private val _books = MutableLiveData<Response<List<Book>>>()
        val books: LiveData<Response<List<Book>>> get() = _books

        fun fetchBooks() {
            viewModelScope.launch {
                _books.postValue(Response.loading(null))
                _books.postValue(getBooksUseCase.invoke("2023-09-01", "hardcover-fiction"))
            }
        }
    }
