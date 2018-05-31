package radioshowslisting.radioshowslisting.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import radioshowslisting.radioshowslisting.RadioShowsListingApplication
import radioshowslisting.radioshowslisting.main.di.MainModule
import javax.inject.Singleton

@Component(
        modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        MainModule::class,
        NetworkModule::class
        ]
)
@Singleton
interface AppInjector {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppInjector
    }

    fun inject(app: RadioShowsListingApplication)
}

