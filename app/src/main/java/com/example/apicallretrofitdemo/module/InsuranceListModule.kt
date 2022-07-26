package com.example.apicallretrofitdemo.module

import com.example.apicallretrofitdemo.api.InsuranceService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class) // HERE
class InsuranceListModule {

    @Provides
    fun getApiInterface(retroFit: Retrofit): InsuranceService {
        return retroFit.create(InsuranceService::class.java)
    }

    @Provides
    fun getRetrofit( okHttpClient: OkHttpClient, mosh: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mobdevtest2.imscareportal.com:10443/imsgo/mservices/")
            .addConverterFactory(MoshiConverterFactory.create(mosh))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Provides
    fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }
}