package co.nimblehq.di

import android.app.Application
import co.nimblehq.TemplateApplication
import co.nimblehq.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        RetrofitModule::class,
        GsonModule::class,
        OkHttpClientModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<TemplateApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
