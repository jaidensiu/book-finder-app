package com.jaidensiu.bookfinderapp

import android.app.Application
import com.jaidensiu.bookfinderapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}