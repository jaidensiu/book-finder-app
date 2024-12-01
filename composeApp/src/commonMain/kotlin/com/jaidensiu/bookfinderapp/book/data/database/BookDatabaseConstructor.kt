package com.jaidensiu.bookfinderapp.book.data.database

import androidx.room.RoomDatabaseConstructor

@Suppress(names = ["NO_ACTUAL_FOR_EXPECT"])
expect object BookDatabaseConstructor: RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase
}
