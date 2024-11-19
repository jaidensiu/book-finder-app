package com.jaidensiu.bookfinderapp.book.presentation.book_list

enum class BookListPage(val index: Int) {
    SEARCH_RESULTS(index = 0),
    FAVORITES(index = 1);

    companion object {
        fun fromIndex(index: Int): BookListPage {
            return entries.firstOrNull { it.index == index } ?: SEARCH_RESULTS
        }
    }
}
