package com.bibin.countries.countrylistmanagement.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bibin.countries.base.presentation.BaseViewModel
import com.bibin.countries.base.presentation.Status
import com.bibin.countries.base.presentation.responseEntityToResponse
import com.bibin.countries.countrylistmanagement.domain.CountryListManageUseCase
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryListManageViewModel @Inject constructor(private val countryListManageUseCase: CountryListManageUseCase) :
    BaseViewModel() {
    private var disposable: Disposable? = null
    val countryListObservable = MutableLiveData<List<CountryListEntity>>()

    fun getCountryList() {
        if (responseStatusLiveData.value != Status.Loading) {
            disposable?.dispose()
            responseStatusLiveData.postValue(Status.Loading)
            disposable =
                countryListManageUseCase.getCountryList().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).map {
                        //api call is success when status = OK
                        countryListObservable.value = it.results
                        //Handle loading and api error cases if any
                        handleApiResponse(it.responseEntityToResponse())
                    }.onErrorReturn {
                        Log.d("HttpError :", "$it")
                    }.subscribe()

            disposable?.let { addDisposable(it) }
        }
    }
}