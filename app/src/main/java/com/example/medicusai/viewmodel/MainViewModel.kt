package com.example.medicusai.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.medicusai.base.BaseViewModel
import com.example.medicusai.model.Biomarker
import com.example.medicusai.network.ApiInterface
import com.example.medicusai.network.RetrofitProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {
    @Inject
    lateinit var retrofit: Retrofit
    var biomarkerList = MutableLiveData<List<Biomarker>>()
//TODO() run it again without the comment code
/*
        get() = field
        set(value) {
            field = value
        }
*/
    fun apiRequest() {
        compositeDisposable.add( retrofit
            .create(ApiInterface::class.java)
            .getAllBiomarker().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())//use incomplete instead
            .subscribe({ Biomarkers ->
                var list: List<Biomarker> = listOf()

                for (biomarker in Biomarkers) {
                    if (biomarker.date != null)
                        list += biomarker
                }

                biomarkerList.postValue(list.toList())
            }, { _ ->
            }))

    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}