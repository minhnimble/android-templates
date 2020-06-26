package co.nimblehq.ui.screens

import android.os.Bundle
import android.view.View.*
import co.nimblehq.R
import co.nimblehq.extension.loadImage
import co.nimblehq.lib.IsLoading
import co.nimblehq.ui.base.BaseActivity
import co.nimblehq.ui.screens.data.Data
import co.nimblehq.ui.screens.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModelClass = MainViewModel::class

    override val layoutRes: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO update in next PR
//        buttonRefresh.clicks()
//            .subscribe { viewModel.inputs.refresh() }
//            .bindForDisposable()
//
//        buttonNext.clicks()
//            .subscribe { viewModel.inputs.next()}
//            .bindForDisposable()
    }

    override fun bindViewModel() {
        viewModel.outputs.loadData() bindTo ::bindData
        viewModel.outputs.isLoading() bindTo ::showLoading
        viewModel.outputs.gotoNextScreen() bindTo ::gotoNextScreen
    }

    private fun bindData(data: Data) {
        textView.text = data.content
        imageView.loadImage(data.imageUrl)
    }

    private fun showLoading(isLoading: IsLoading) {
        buttonRefresh.visibility = if (isLoading) INVISIBLE else VISIBLE
        progressBar.visibility = if (isLoading) VISIBLE else GONE
    }

    private fun gotoNextScreen(data: Data) {
        SecondActivity.show(this, data)
    }
}
