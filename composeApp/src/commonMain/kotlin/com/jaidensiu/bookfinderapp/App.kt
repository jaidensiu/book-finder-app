package com.jaidensiu.bookfinderapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.jaidensiu.bookfinderapp.book.data.network.KtorRemoteBookDataSource
import com.jaidensiu.bookfinderapp.book.data.repository.DefaultBookRepository
import com.jaidensiu.bookfinderapp.book.presentation.book_list.BookListScreenRoot
import com.jaidensiu.bookfinderapp.book.presentation.book_list.BookListViewModel
import com.jaidensiu.bookfinderapp.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine = engine
                        )
                    )
                )
            )
        },
        onBookClick = {}
    )
}
