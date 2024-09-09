package ru.alexandrorlov.avito_test.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.alexandrorlov.avito_test.data.local.models.TokenDBO

@Dao
interface TokenDao {

    @Query("SELECT * FROM Token")
    suspend fun getAllToken(): List<TokenDBO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(token: TokenDBO)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateToken(token: TokenDBO)

    @Delete
    suspend fun removeToken(token: TokenDBO)

    @Query("DELETE FROM Token")
    suspend fun clean()
}