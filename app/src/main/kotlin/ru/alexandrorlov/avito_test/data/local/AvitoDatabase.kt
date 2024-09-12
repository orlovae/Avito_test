package ru.alexandrorlov.avito_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.alexandrorlov.avito_test.data.local.dao.TokenDao
import ru.alexandrorlov.avito_test.data.local.models.TokenDBO

@Database(entities = [TokenDBO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tokenDao(): TokenDao

    companion object {
        const val DB_NAME = "avito.db"
    }

}
