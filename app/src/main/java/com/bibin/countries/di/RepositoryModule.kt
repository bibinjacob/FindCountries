package com.bibin.countries.di

import com.bibin.countries.base.data.network.RepoService
import com.bibin.countries.countrylistmanagement.data.CountryListManageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCountryListManageRepository(repoService: RepoService): CountryListManageRepository {
        return CountryListManageRepository(repoService)
    }
}