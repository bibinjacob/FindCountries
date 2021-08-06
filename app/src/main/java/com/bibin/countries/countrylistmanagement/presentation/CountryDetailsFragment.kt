package com.bibin.countries.countrylistmanagement.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bibin.countries.R
import com.bibin.countries.base.presentation.BaseFragment
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import com.bibin.countries.databinding.FragmentCountryDetailsBinding
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryDetailsFragment : BaseFragment() {
    lateinit var binding: FragmentCountryDetailsBinding
    private lateinit var countryDetailViewModel: CountryDetailViewModel
    private var country: CountryListEntity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        countryDetailViewModel =
            ViewModelProvider(this, viewModelFactory).get(CountryDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        fetchArguments()
    }

    private fun fetchArguments() {
        arguments?.let {
            country = it.getParcelable(getString(R.string.arg_country))
            binding.country = country
            val uri = Uri.parse(country?.flag)
            GlideToVectorYou.justLoadImage(activity, uri, binding.imageCountry)
        }
    }
}