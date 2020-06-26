package co.nimblehq.di.modules.screens

import androidx.lifecycle.ViewModel
import co.nimblehq.di.FragmentScope
import co.nimblehq.di.ViewModelKey
import co.nimblehq.ui.screens.second.SecondViewModel
import co.nimblehq.ui.screens.second.SecondViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SecondFragmentModule {

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(SecondViewModel::class)
    fun secondViewModel(viewModel: SecondViewModelImpl): ViewModel

}
