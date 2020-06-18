package co.nimblehq.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import co.nimblehq.TemplateApplication
import co.nimblehq.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelFactoryModule::class,
    AppModule::class,
    RetrofitModule::class,
    GsonModule::class,
    OkHttpClientModule::class,
    SchedulersModule::class,
    ActivityBuilderModule::class])
interface ApplicationComponent : AndroidInjector<TemplateApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TemplateApplication>()
}
