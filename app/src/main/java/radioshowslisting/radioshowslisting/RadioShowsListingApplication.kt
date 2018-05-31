package radioshowslisting.radioshowslisting

import android.app.Activity
import android.app.Application
import android.app.Service
import android.support.v7.app.AppCompatDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import radioshowslisting.radioshowslisting.di.DaggerAppInjector
import java.util.*
import javax.inject.Inject

class RadioShowsListingApplication : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingAndroidServiceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()

        DaggerAppInjector.builder()
                .application(this)
                .build()
                .inject(this)

        resources.configuration.setLocale(Locale("sv", "SE"))
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = dispatchingAndroidServiceInjector

    companion object {

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }
}

