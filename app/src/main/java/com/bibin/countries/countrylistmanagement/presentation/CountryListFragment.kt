package com.bibin.countries.countrylistmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bibin.countries.R
import com.bibin.countries.base.presentation.BaseFragment
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import com.bibin.countries.databinding.FragmentCountryListBinding

class CountryListFragment : BaseFragment() {
    lateinit var binding: FragmentCountryListBinding
    private lateinit var countryListManageViewModel: CountryListManageViewModel
    private lateinit var countryListAdapter: CountryListAdapter
    private var countryList = mutableListOf<CountryListEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        countryListManageViewModel =
            ViewModelProvider(this, viewModelFactory).get(CountryListManageViewModel::class.java)
        binding.countryListManageViewModel = countryListManageViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        initViews()
    }

    private fun initViews() {
        countryListAdapter = CountryListAdapter(countryList, listItemClickCallback)
        binding.recyclerViewCountryList.adapter = countryListAdapter
        countryListManageViewModel.getCountryList()
    }

    private fun setObservers() {
        countryListManageViewModel.countryListObservable.observe(viewLifecycleOwner, Observer {
            countryListAdapter.updateList(it)
        })
    }

    private val listItemClickCallback = object : ListItemClickCallback {
        override fun onItemClick(country: CountryListEntity) {
            val bundle = Bundle().apply {
                putParcelable(
                    getString(R.string.arg_country),
                    country
                )
            }
            findNavController().navigate(
                R.id.action_fragmentCountryList_to_fragmentCountryDetails,
                bundle
            )
        }
    }
}