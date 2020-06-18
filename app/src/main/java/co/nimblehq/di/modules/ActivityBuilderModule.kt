package co.nimblehq.di.modules

import co.nimblehq.ui.main.MainActivity
import co.nimblehq.ui.main.di.MainActivityModule
import co.nimblehq.ui.second.SecondActivity
import co.nimblehq.ui.second.di.SecondActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun bindSecondActivity(): SecondActivity
}
