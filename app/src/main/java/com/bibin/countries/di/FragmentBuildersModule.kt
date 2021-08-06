package com.bibin.countries.di

import com.bibin.countries.countrylistmanagement.presentation.CountryListFragment
import com.bibin.countries.countrylistmanagement.presentation.CountryDetailsFragment
import com.bibin.countries.splash.presentation.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeCountryListFragment(): CountryListFragment

    @ContributesAndroidInjector
    abstract fun contributeCountryDetailsFragment(): CountryDetailsFragment

}