package co.nimblehq.di.modules

import co.nimblehq.di.ActivityScope
import co.nimblehq.di.modules.screens.MainActivityFragmentModule
import co.nimblehq.di.modules.screens.MainActivityModule
import co.nimblehq.ui.screens.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainActivityFragmentModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}
