package com.androidpoet.cleanarchitecture.di

import com.androidpoet.cleanarchitecture.BuildConfig
import com.androidpoet.cleanarchitecture.data.remote.MoviesApiService
import com.androidpoet.cleanarchitecture.data.remote.adapter.NetworkResultCallAdapterFactory
import com.androidpoet.cleanarchitecture.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Core Module used to generate core features such as interceptors, clients and
     * Retrofit instance
     **/
    @Provides
    @Singleton
    fun apiKeyInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            var request = chain.request()
            val url: HttpUrl =
                request.url.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.apiKey) // API-Key
                    .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

    }


    @Provides
    @Singleton
    fun provideLoggerInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideClientDispatcher(): Dispatcher {
        return Dispatcher().apply {
            maxRequests = 1
        }
    }

    @Provides
    @Singleton
    fun provideClient(
        logger: HttpLoggingInterceptor,
        dispatcher: Dispatcher,
        interceptor: Interceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(interceptor)
            .dispatcher(dispatcher)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinService(retrofit: Retrofit): MoviesApiService {
        return retrofit.create(MoviesApiService::class.java)
    }


}