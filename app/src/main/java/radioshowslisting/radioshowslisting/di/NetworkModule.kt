package radioshowslisting.radioshowslisting.di

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import radioshowslisting.radioshowslisting.R
import radioshowslisting.radioshowslisting.api.RadioShowsListingApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient
                    .Builder()
                    .build()

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(application: Application, client: OkHttpClient, moshi: Moshi) = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .baseUrl(application.getString(R.string.base_url))
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): RadioShowsListingApi = retrofit.create(RadioShowsListingApi::class.java)

}

