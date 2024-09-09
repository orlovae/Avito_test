package ru.alexandrorlov.avito_test.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.alexandrorlov.avito_test.data.local.AppDatabase
import ru.alexandrorlov.avito_test.data.local.AppDatabase.Companion.DB_NAME
import ru.alexandrorlov.avito_test.data.local.dao.TokenDao
import ru.alexandrorlov.avito_test.di.AppScope

@Module
class DatabaseModule {

    @[Provides AppScope]
    fun localSource(database: AppDatabase): TokenDao =
        database.tokenDao()


    @[Provides AppScope]
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME,
        )
            .fallbackToDestructiveMigration()
            .build()
}
