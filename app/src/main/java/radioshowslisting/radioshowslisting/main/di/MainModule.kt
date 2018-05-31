package radioshowslisting.radioshowslisting.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import radioshowslisting.radioshowslisting.main.ui.MainActivity

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}