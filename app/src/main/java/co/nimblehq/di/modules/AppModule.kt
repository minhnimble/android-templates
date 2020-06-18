package co.nimblehq.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import co.nimblehq.TemplateApplication

@Module
class AppModule {

    @Provides
    fun provideContext(application: TemplateApplication): Context = application
}
