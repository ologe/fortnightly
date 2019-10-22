package dev.olog.fortnightly.presentation.main.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.olog.fortnightly.app.di.qualifier.ViewModelKey
import dev.olog.fortnightly.presentation.main.MainActivityViewModel

@Module
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideViewModel(factory: MainActivityViewModel): ViewModel

}