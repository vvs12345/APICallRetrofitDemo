package com.example.apicallretrofitdemo.module

import androidx.lifecycle.ViewModel
import com.example.apicallretrofitdemo.api.InsuranceService
import com.example.apicallretrofitdemo.utils.ViewModelKey
import com.example.apicallretrofitdemo.view_models.InsuranceListViewModel
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // HERE
class InsuranceListModule {

    @Provides
    fun getApiInterface(retroFit: Retrofit): InsuranceService {
        return retroFit.create(InsuranceService::class.java)
    }

    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, mosh: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(MoshiConverterFactory.create(mosh))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesMoshi() = Moshi.Builder().build()

    @Provides
    fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return httpLoggingInterceptor.let {
            OkHttpClient.Builder()
                .addInterceptor(it)
                .build()
        }
    }

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @IntoMap
    @Provides
    @ViewModelKey(InsuranceListViewModel::class)
    @ActivityScoped
    fun provideViewModel(listViewModel: InsuranceListViewModel): ViewModel = listViewModel

}