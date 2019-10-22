package dev.olog.fortnightly.data.di

import dagger.Binds
import dagger.Module
import dev.olog.fortnightly.core.ArticlesGateway
import dev.olog.fortnightly.data.repository.ArticleRepository
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideArticleRepo(impl: ArticleRepository): ArticlesGateway

}