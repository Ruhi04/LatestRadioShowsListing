package radioshowslisting.radioshowslisting.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import radioshowslisting.radioshowslisting.RadioShowsListingViewModelFactory
import radioshowslisting.radioshowslisting.main.ui.MainViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: RadioShowsListingViewModelFactory): ViewModelProvider.Factory

}
