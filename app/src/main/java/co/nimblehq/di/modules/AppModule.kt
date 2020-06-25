package co.nimblehq.di.modules

import android.app.Application
import android.content.Context
import co.nimblehq.di.ApplicationScope
import co.nimblehq.domain.schedulers.BaseSchedulerProvider
import co.nimblehq.domain.schedulers.SchedulerProvider
import dagger.*

@Module
abstract class AppModule {

    @Binds
    @ApplicationScope
    internal abstract fun provideContext(application: Application): Context

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ApplicationScope
        fun schedulerProvider(): BaseSchedulerProvider = SchedulerProvider()
    }
}
