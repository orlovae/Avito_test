package ru.alexandrorlov.avito_test.feature.product.domain.repository

import ru.alexandrorlov.avito_test.feature.product.data.models.Category

interface HeaderRepository {

    suspend fun getAllCategory(): List<Category>



}
