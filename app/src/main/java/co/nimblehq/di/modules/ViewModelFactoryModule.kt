package co.nimblehq.di.modules

import androidx.lifecycle.ViewModelProvider
import co.nimblehq.lib.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
