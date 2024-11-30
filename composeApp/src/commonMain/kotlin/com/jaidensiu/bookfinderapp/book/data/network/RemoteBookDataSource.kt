package com.jaidensiu.bookfinderapp.book.data.network

import com.jaidensiu.bookfinderapp.book.data.dto.BookWorkDto
import com.jaidensiu.bookfinderapp.book.data.dto.SearchResponseDto
import com.jaidensiu.bookfinderapp.core.domain.DataError
import com.jaidensiu.bookfinderapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(
        bookWorkId: String
    ): Result<BookWorkDto, DataError.Remote>
}
