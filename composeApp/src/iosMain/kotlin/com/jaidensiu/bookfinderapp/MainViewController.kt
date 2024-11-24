package com.jaidensiu.bookfinderapp

import androidx.compose.ui.window.ComposeUIViewController
import com.jaidensiu.bookfinderapp.app.App
import com.jaidensiu.bookfinderapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}
