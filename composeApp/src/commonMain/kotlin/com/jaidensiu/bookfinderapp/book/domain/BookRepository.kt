package com.jaidensiu.bookfinderapp.book.domain

import com.jaidensiu.bookfinderapp.core.domain.DataError
import com.jaidensiu.bookfinderapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}
