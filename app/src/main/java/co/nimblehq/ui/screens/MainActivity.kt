package co.nimblehq.ui.screens

import co.nimblehq.R
import co.nimblehq.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModelImpl>() {

    override val viewModelClass = MainViewModelImpl::class

    override val layoutRes: Int = R.layout.activity_main

    override fun bindViewModel() {}

}
