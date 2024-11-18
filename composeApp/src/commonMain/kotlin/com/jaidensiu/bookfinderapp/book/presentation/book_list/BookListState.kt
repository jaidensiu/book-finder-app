package com.jaidensiu.bookfinderapp.book.presentation.book_list

import com.jaidensiu.bookfinderapp.book.domain.Book
import com.jaidensiu.bookfinderapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
