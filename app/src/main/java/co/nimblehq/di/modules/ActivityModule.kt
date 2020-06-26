package co.nimblehq.di.modules

import co.nimblehq.di.ActivityScope
import co.nimblehq.di.modules.screens.MainActivityModule
import co.nimblehq.di.modules.screens.second.SecondActivityModule
import co.nimblehq.ui.screens.MainActivity
import co.nimblehq.ui.screens.second.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun bindSecondActivity(): SecondActivity
}
