package dev.olog.fortnightly.presentation.main

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.olog.fortnightly.app.di.qualifier.PerActivity

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class MainActivityInjector {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(factory: MainActivitySubComponent.Factory): AndroidInjector.Factory<*>

}

@Subcomponent(
    modules = [
//        SearchFragmentModule::class,
//        DetailFragmentModule::class,
//        HistoryFragmentModule::class
    ]
)
@PerActivity
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>

}