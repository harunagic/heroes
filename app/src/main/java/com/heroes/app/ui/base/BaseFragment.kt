package com.heroes.app.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.heroes.app.App
import com.heroes.app.di.component.AppComponent
import javax.inject.Inject

abstract class BaseFragment<V : ViewDataBinding, T : BaseViewModel>(@LayoutRes val resId: Int) : Fragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  protected lateinit var dataBinding: V
  protected lateinit var viewModel: T

  abstract fun getViewModel(factory: ViewModelProvider.Factory): T
  abstract fun getBindingVariable(): Int

  protected open fun inject(appComponent: AppComponent) {
  }

  override fun onAttach(context: Context) {
    inject(App.appComponent)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dataBinding = DataBindingUtil.inflate(inflater, resId, container, false)
    viewModel = getViewModel(viewModelFactory)
    dataBinding.setVariable(getBindingVariable(), viewModel)
    return dataBinding.root
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    setupUI()
    setupListeners()
  }

  /**
   * Override in fragment and process UI stuff that you need
   */
  open fun setupUI() {

  }

  /**
   * Override in fragment and setup listeners
   */
  open fun setupListeners() {

  }
}
