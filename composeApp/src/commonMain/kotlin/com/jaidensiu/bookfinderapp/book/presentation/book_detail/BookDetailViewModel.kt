package com.jaidensiu.bookfinderapp.book.presentation.book_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.jaidensiu.bookfinderapp.app.Route
import com.jaidensiu.bookfinderapp.book.domain.BookRepository
import com.jaidensiu.bookfinderapp.core.domain.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookDetailViewModel(
    private val bookRepository: BookRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(BookDetailState())
    val state = _state
        .onStart {
            fetchBookDescription()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000L),
            initialValue = _state.value
        )

    fun onAction(action: BookDetailAction) {
        when (action) {
            is BookDetailAction.OnSelectedBookChange -> {
                _state.update {
                    it.copy(book = action.book)
                }
            }
            BookDetailAction.OnBackClick -> {

            }
            BookDetailAction.OnFavoriteClick -> {

            }
        }
    }

    private fun fetchBookDescription() {
        val bookId = savedStateHandle.toRoute<Route.BookDetail>().id

        viewModelScope.launch {
            bookRepository
                .getBookDescription(bookId = bookId)
                .onSuccess { description ->
                    _state.update {
                        it.copy(
                            book = it.book?.copy(description = description),
                            isLoading = false
                        )
                    }
                }
        }
    }
}
