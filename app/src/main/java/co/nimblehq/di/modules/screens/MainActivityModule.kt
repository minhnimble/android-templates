package co.nimblehq.di.modules.screens

import androidx.lifecycle.ViewModel
import co.nimblehq.di.ActivityScope
import co.nimblehq.di.ViewModelKey
import co.nimblehq.domain.repository.ApiRepository
import co.nimblehq.domain.repository.ApiRepositoryImpl
import co.nimblehq.ui.screens.MainViewModel
import co.nimblehq.ui.screens.MainViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModelImpl): ViewModel

    @Binds
    @ActivityScope
    fun apiRepository(repository: ApiRepositoryImpl): ApiRepository
}
