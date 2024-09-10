package ru.alexandrorlov.avito_test.data.network.di

import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import ru.alexandrorlov.avito_test.data.network.interceptor.AuthHeaderInterceptor
import ru.alexandrorlov.avito_test.data.network.utils.NetworkConstants.BASE_URL
import ru.alexandrorlov.avito_test.di.AppScope
import ru.alexandrorlov.avito_test.feature.authentication.data.source.AuthApi
import ru.alexandrorlov.avito_test.feature.product.data.source.ProductListApi
import ru.alexandrorlov.avito_test.feature.registration.data.source.RegistrationApi

@Module
class NetworkModule {

    @[Provides AppScope]
    fun provideRegistrationApi(retrofit: Retrofit): RegistrationApi = retrofit.create()

    @[Provides AppScope]
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create()

    @[Provides AppScope]
    fun provideProductListApi(retrofit: Retrofit): ProductListApi = retrofit.create()
//
//    @[Provides AppScope]
//    fun provideProductDetailApi(retrofit: Retrofit): DetailProductApi = retrofit.create()

    @[Provides AppScope]
    fun provideRetrofit(
        factory: Converter.Factory,
        httpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(factory)
            .client(httpClient)
            .build()

    @Provides
    fun getConverterFactory(): Converter.Factory {
        val json: Json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        val mediaType: MediaType = "application/json".toMediaType()

        return json.asConverterFactory(mediaType)
    }

    @Provides
    fun getOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthHeaderInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}