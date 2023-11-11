package org.zaim.na.kartu.polus.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.kredit.onlain.merca.data.ApiAnalytic
import com.kredit.onlain.merca.data.ApiServer
import com.kredit.onlain.merca.data.URL_ANALYTICS
import com.kredit.onlain.merca.data.URL_SERVER
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideApiAnalytic(): ApiAnalytic {
        return Retrofit.Builder()
            .baseUrl(URL_ANALYTICS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiAnalytic::class.java)
    }

    @Provides
    @Singleton
    fun provideApiServer(): ApiServer {
        return Retrofit.Builder()
            .baseUrl(URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServer::class.java)
    }
}