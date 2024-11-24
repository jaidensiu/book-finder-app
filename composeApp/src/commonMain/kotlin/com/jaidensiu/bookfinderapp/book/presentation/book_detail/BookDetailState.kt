package com.jaidensiu.bookfinderapp.book.presentation.book_detail

import com.jaidensiu.bookfinderapp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
