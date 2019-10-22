package dev.olog.fortnightly.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.olog.fortnightly.presentation.main.MainActivityInjector
import dev.olog.fortnightly.presentation.viewmodel.ViewModelModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,

        ViewModelModule::class,
        MainActivityInjector::class

//        DataModule::class,
//        NetworkModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance instance: Application): AppComponent
    }

}

