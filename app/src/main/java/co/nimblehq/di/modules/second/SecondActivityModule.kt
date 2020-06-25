package co.nimblehq.di.modules.second

import androidx.lifecycle.ViewModel
import co.nimblehq.di.ActivityScope
import co.nimblehq.di.ViewModelKey
import co.nimblehq.ui.second.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class SecondActivityModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel
}
