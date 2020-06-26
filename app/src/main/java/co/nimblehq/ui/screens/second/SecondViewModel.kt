package co.nimblehq.ui.screens.second

import co.nimblehq.domain.schedulers.BaseSchedulerProvider
import co.nimblehq.ui.base.BaseViewModel
import co.nimblehq.ui.screens.home.Data
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val schedulers: BaseSchedulerProvider
) : BaseViewModel(), Inputs, Outputs {

    private val persistData = BehaviorSubject.create<Data>()

    val inputs: Inputs = this
    val outputs: Outputs = this

    init {
//        val dataFromIntent = intent()
//            .subscribeOn(schedulers.io())
//            .map { it.getParcelableExtra<Data>(Const.EXTRAS_DATA) }
//
//        dataFromIntent
//            .subscribe(persistData::onNext)
//            .bindForDisposable()
    }

    override fun setPersistedData() = this.persistData!!
}

interface Inputs {
}

interface Outputs {
    fun setPersistedData(): Observable<Data>
}
