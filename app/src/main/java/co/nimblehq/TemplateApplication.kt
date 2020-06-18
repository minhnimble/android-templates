package co.nimblehq

import android.content.Context
import androidx.multidex.MultiDex
import co.nimblehq.di.DaggerApplicationComponent
import co.nimblehq.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class TemplateApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<TemplateApplication> =
            DaggerApplicationComponent.builder().create(this)

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        plantTimber()
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
