package com.example.medicusai.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.medicusai.base.BaseViewModel
import com.example.medicusai.model.Biomarker
import com.example.medicusai.network.ApiInterface
import com.example.medicusai.network.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {
    var biomarkerList = MutableLiveData<List<Biomarker>>()
        get() = field
        set(value) {
            field = value
        }

    fun apiRequest() {
        compositeDisposable.add( RetrofitInstance.getRetrofitInstance()
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
//        with(RetrofitInstance) {
//            getRetrofitInstance()
//                .create(ApiInterface::class.java)
//                .getAllBiomarker().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())//use incomplete instead
//                .subscribe({ Biomarkers ->
//                    var list: List<Biomarker> = listOf()
//
//                    for (biomarker in Biomarkers) {
//                        if (biomarker.date != null)
//                            list += biomarker
//                    }
//
//                    biomarkerList.postValue(list.toList())
//                }, { error ->
//                })
//        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}