package org.zaim.na.kartu.polus.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.kredit.onlain.merca.data.RepositoryAnalyticImpl
import com.kredit.onlain.merca.data.RepositoryServerImpl
import com.kredit.onlain.merca.data.ServiceImpl
import com.kredit.onlain.merca.data.SharedKeeperImpl
import org.zaim.na.kartu.polus.domain.RepositoryAnalytic
import org.zaim.na.kartu.polus.domain.RepositoryServer
import org.zaim.na.kartu.polus.domain.Service
import org.zaim.na.kartu.polus.domain.SharedKepper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKepper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}