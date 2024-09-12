package ru.alexandrorlov.avito_test.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestWithHeader: Request = chain.request()
            .newBuilder()
            .build()
        return chain.proceed(requestWithHeader)
    }

    private fun getHeader(): String = ""
}
