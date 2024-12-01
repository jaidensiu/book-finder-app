package com.jaidensiu.bookfinderapp.book.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains(other = "win") -> {
                File(System.getenv("APPDATA"), "Bookpedia")
            }
            os.contains(other = "mac") -> {
                File(userHome, "Library/Application Support/Bookpedia")
            }
            else -> {
                File(userHome, ".local/share/Bookpedia")
            }
        }

        if (!appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, FavoriteBookDatabase.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}
