package ru.alexandrorlov.avito_test.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Token")
data class TokenDBO(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("token") val token: String,
)
