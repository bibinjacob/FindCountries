package com.bibin.countries.di

import com.bibin.countries.countrylistmanagement.data.CountryListManageRepository
import com.bibin.countries.countrylistmanagement.domain.CountryListManageUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseRepository {

    @Singleton
    @Provides
    fun provideCountryListManageUseCase(countryListManageRepository: CountryListManageRepository): CountryListManageUseCase {
        return CountryListManageUseCase(countryListManageRepository)
    }
}