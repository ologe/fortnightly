package dev.olog.fortnightly.presentation.main.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.olog.fortnightly.presentation.main.MainActivity

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class MainActivityInjector {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindActivity(factory: MainActivitySubComponent.Factory): AndroidInjector.Factory<*>

}

