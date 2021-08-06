package com.bibin.countries.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bibin.countries.countrylistmanagement.presentation.CountryDetailViewModel
import com.bibin.countries.countrylistmanagement.presentation.CountryListManageViewModel
import com.bibin.countries.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryListManageViewModel::class)
    abstract fun bindCountryListManageViewModel(countryListManageViewModel: CountryListManageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailViewModel::class)
    abstract fun bindCountryDetailViewModel(countryDetailViewModel: CountryDetailViewModel): ViewModel
}