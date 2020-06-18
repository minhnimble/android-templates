package co.nimblehq.ui.main.di

import androidx.lifecycle.ViewModel
import co.nimblehq.di.ViewModelKey
import co.nimblehq.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
