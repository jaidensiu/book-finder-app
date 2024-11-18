package com.jaidensiu.bookfinderapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform