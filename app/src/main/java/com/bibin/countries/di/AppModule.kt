package com.bibin.countries.di

import com.bibin.countries.BuildConfig
import com.bibin.countries.base.data.network.HeadersInterceptor
import com.bibin.countries.base.data.network.RepoService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): RepoService {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HeadersInterceptor())
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .apply {
                                level = if (BuildConfig.DEBUG)
                                    HttpLoggingInterceptor.Level.BODY
                                else
                                    HttpLoggingInterceptor.Level.NONE
                            })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RepoService::class.java)
    }
}