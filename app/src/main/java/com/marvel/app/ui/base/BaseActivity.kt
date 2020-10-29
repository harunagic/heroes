package com.marvel.app.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity

abstract class BaseActivity(@LayoutRes val resId: Int) : FragmentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(resId)
    setupUI()
    setupListeners()
  }

  /**
   * Override in activity and process UI stuff that you need
   */
  open fun setupUI() {

  }

  /**
   * Override in activity and setup listeners
   */
  open fun setupListeners() {

  }
}
