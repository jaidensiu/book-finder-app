package com.jaidensiu.bookfinderapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jaidensiu.bookfinderapp.book.domain.Book
import com.jaidensiu.bookfinderapp.book.presentation.book_list.BookListScreen
import com.jaidensiu.bookfinderapp.book.presentation.book_list.BookListState
import com.jaidensiu.bookfinderapp.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun BookListScreenPreview() {
    val books = (1..100).map {
        Book(
            id = it.toString(),
            title = "Book $it",
            imageUrl = "https://image.com",
            authors = listOf("Jaiden Siu"),
            description = "Description $it",
            languages = emptyList(),
            firstPublishYear = null,
            averageRating = 8.5555,
            ratingCount = 8,
            numPages = 100,
            numEditions = 2
        )
    }

    BookListScreen(
        state = BookListState(searchResults = books),
        onAction = {}
    )
}