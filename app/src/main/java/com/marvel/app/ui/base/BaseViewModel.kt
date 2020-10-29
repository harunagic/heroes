package com.marvel.app.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

  private var compositeDisposable = CompositeDisposable()

  fun addSubscription(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }

  override fun onCleared() {
    compositeDisposable.clear()
    super.onCleared()
  }
}