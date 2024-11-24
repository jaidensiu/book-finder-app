package com.jaidensiu.bookfinderapp.book.presentation.book_detail

import com.jaidensiu.bookfinderapp.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}
