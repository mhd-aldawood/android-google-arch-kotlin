package com.example.medicusai.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
}