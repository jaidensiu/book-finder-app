package com.jaidensiu.bookfinderapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.jaidensiu.bookfinderapp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Book Finder App"
        ) {
            App()
        }
    }
}
