package dev.olog.fortnightly.data.di

import dagger.Lazy
import dagger.Module
import dagger.Provides
import dev.olog.fortnightly.data.service.ArticleService
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideArticleService(client: Lazy<OkHttpClient>): ArticleService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .callFactory(object : Call.Factory {
                override fun newCall(request: Request): Call {
                    // delegate okhttp initialization to the first call
                    return client.get().newCall(request)
                }
            })
            .build()

        return retrofit.create(ArticleService::class.java)
    }


}