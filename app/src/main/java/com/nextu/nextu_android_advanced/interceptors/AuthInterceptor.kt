package com.nextu.nextu_android_advanced.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-apisports-key", "4827962357b3841db991cc8886d11d42")
            .build()
        return chain.proceed(request)
    }
}