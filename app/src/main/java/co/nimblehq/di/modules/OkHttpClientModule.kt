package co.nimblehq.di.modules

import co.nimblehq.BuildConfig
import co.nimblehq.data.service.interceptor.AppRequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class OkHttpClientModule {
    @Provides
    fun provideOkHttpClient(apiRequestInterceptor: AppRequestInterceptor,
                            httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder().addInterceptor(apiRequestInterceptor)
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(httpLoggingInterceptor)
        }
        return httpClient.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}