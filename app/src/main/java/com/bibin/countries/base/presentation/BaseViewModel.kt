package com.bibin.countries.base.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val responseStatusLiveData = MutableLiveData<Status>()
    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun setStatusError() = responseStatusLiveData.postValue(Status.Failure)

    private fun setStatusSuccess() = responseStatusLiveData.postValue(Status.Successful)

    fun handleApiResponse(response: Response) {
        if (response.status == "OK") {
            setStatusSuccess()
        } else {
            setStatusError()
        }
        //responseSuccessLiveData.postValue(SingleLiveEvent(response))
    }

    private fun clearDisposables() = compositeDisposable.clear()

    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }
}