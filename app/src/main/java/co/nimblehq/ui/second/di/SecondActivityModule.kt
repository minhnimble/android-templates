package co.nimblehq.ui.second.di

import androidx.lifecycle.ViewModel
import co.nimblehq.di.ViewModelKey
import co.nimblehq.ui.second.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class SecondActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel
}
