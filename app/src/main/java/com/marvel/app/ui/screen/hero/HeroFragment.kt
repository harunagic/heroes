package com.marvel.app.ui.screen.hero

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import com.marvel.app.BR
import com.marvel.app.R
import com.marvel.app.databinding.HeroFragmentBinding
import com.marvel.app.di.component.AppComponent
import com.marvel.app.ui.base.BaseFragment
import com.marvel.app.ui.screen.hero.data.HeroAdapter
import com.marvel.app.ui.screen.hero.data.HeroItemDecorator
import com.marvel.app.util.json
import com.marvel.app.util.onTextChange
import javax.inject.Inject

class HeroFragment : BaseFragment<HeroFragmentBinding, HeroViewModel>(R.layout.hero_fragment) {

  @Inject
  lateinit var heroAdapter: HeroAdapter

  override fun inject(appComponent: AppComponent) {
    appComponent.inject(this)
  }

  override fun getViewModel(factory: Factory): HeroViewModel = ViewModelProvider(this, factory).get(HeroViewModel::class.java)
  override fun getBindingVariable(): Int = BR.viewModel

  override fun setupUI() {
    dataBinding.listHeroes.addItemDecoration(HeroItemDecorator())
    dataBinding.listHeroes.adapter = heroAdapter
  }

  override fun setupListeners() {
    heroAdapter.callback = {
      findNavController().navigate(HeroFragmentDirections.actionHeroFragmentToHeroDetailsFragment(it.json()))
    }

    dataBinding.inputName.onTextChange {
      viewModel.inputTextPublisher.onNext(it)
    }

    dataBinding.btnClear.setOnClickListener {
      dataBinding.inputName.clearFocus()
      dataBinding.inputName.setText("")
      viewModel.clearSearches()
    }
  }
}