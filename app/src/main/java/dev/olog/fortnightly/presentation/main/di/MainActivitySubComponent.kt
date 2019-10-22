package dev.olog.fortnightly.presentation.main.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.olog.fortnightly.app.di.qualifier.PerActivity
import dev.olog.fortnightly.presentation.main.MainActivity

@Subcomponent(
    modules = [
        MainActivityModule::class
    ]
)
@PerActivity
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory :
        AndroidInjector.Factory<MainActivity>

}