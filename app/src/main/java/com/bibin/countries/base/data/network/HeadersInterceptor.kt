package com.bibin.countries.base.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                /* .addHeader(
                     ACCESS_TOKEN_HEADER_KEY,
                     ""
                 )
                 .addHeader(X_API_KEY, "")*/
                .build()
        )
    }
}

