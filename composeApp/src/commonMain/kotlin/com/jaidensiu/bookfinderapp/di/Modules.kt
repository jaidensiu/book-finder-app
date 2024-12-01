package com.jaidensiu.bookfinderapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.jaidensiu.bookfinderapp.book.data.database.DatabaseFactory
import com.jaidensiu.bookfinderapp.book.data.database.FavoriteBookDatabase
import com.jaidensiu.bookfinderapp.book.data.network.KtorRemoteBookDataSource
import com.jaidensiu.bookfinderapp.book.data.network.RemoteBookDataSource
import com.jaidensiu.bookfinderapp.book.data.repository.DefaultBookRepository
import com.jaidensiu.bookfinderapp.book.domain.BookRepository
import com.jaidensiu.bookfinderapp.book.presentation.SelectedBookViewModel
import com.jaidensiu.bookfinderapp.book.presentation.book_detail.BookDetailViewModel
import com.jaidensiu.bookfinderapp.book.presentation.book_list.BookListViewModel
import com.jaidensiu.bookfinderapp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()
    single { get<DatabaseFactory>().create().setDriver(BundledSQLiteDriver()).build() }
    single { get<FavoriteBookDatabase>().favoriteBookDao }
    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}
