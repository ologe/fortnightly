package dev.olog.fortnightly.app

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dev.olog.fortnightly.app.di.scope.ApplicationContext

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    internal abstract fun provideContext(instance: Application): Context

}