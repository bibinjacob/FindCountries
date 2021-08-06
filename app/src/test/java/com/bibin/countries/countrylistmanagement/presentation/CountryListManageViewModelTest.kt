package com.bibin.countries.countrylistmanagement.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bibin.countries.base.domain.entity.ResponseEntity
import com.bibin.countries.countrylistmanagement.domain.CountryListManageUseCase
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountryListManageViewModelTest : TestCase() {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var countryListManageUseCase: CountryListManageUseCase

    private lateinit var viewModel: CountryListManageViewModel

    @Before
    public override fun setUp() {
        viewModel = CountryListManageViewModel(countryListManageUseCase)
    }

    @Test
    fun ` verify CountryList size is not empty when getCountryList`() {
        //given
        val responseEntityMock =
            ResponseEntity(results = createCountryList())
        val countryListEntityMock = Single.just(responseEntityMock)
        `when`(countryListManageUseCase.getCountryList()).thenReturn(countryListEntityMock)

        //when
        viewModel.getCountryList()

        //then
        viewModel.countryListObservable.observeForever {
            val listSize = viewModel.countryListObservable.value
            assertTrue(listSize?.size ?: 0 > 0)
        }
    }

    @Test
    fun ` verify CountryList size is  empty when getCountryList`() {
        //given
        val responseEntityMock =
            ResponseEntity(results = createEmptyCountryList())
        val countryListEntityMock = Single.just(responseEntityMock)
        `when`(countryListManageUseCase.getCountryList()).thenReturn(countryListEntityMock)

        //when
        viewModel.getCountryList()

        //then
        viewModel.countryListObservable.observeForever {
            val listSize = viewModel.countryListObservable.value
            assertTrue(listSize?.size ?: 0 == 0)
        }
    }

    private fun createEmptyCountryList(): List<CountryListEntity> {
        return mutableListOf()
    }

    private fun createCountryList(): List<CountryListEntity> {

        val countryList: MutableList<CountryListEntity> = mutableListOf()
        countryList.add(
            CountryListEntity(
                name = "UK",
                region = "Europe",
                capital = "London"
            )
        )
        return countryList
    }
}