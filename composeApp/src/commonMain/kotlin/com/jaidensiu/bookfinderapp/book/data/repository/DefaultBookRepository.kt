package com.jaidensiu.bookfinderapp.book.data.repository

import com.jaidensiu.bookfinderapp.book.data.mappers.toBook
import com.jaidensiu.bookfinderapp.book.data.network.RemoteBookDataSource
import com.jaidensiu.bookfinderapp.book.domain.Book
import com.jaidensiu.bookfinderapp.book.domain.BookRepository
import com.jaidensiu.bookfinderapp.core.domain.DataError
import com.jaidensiu.bookfinderapp.core.domain.Result
import com.jaidensiu.bookfinderapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}
