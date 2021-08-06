package com.bibin.countries.base.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bibin.countries.di.Injectable
import javax.inject.Inject

open class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

}