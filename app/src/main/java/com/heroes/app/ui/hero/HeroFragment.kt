package com.heroes.app.ui.hero

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import com.heroes.app.BR
import com.heroes.app.R
import com.heroes.app.databinding.HeroFragmentBinding
import com.heroes.app.di.component.AppComponent
import com.heroes.app.ui.base.BaseFragment
import com.heroes.app.ui.hero.data.HeroAdapter
import com.heroes.app.ui.hero.data.HeroItemDecorator
import com.heroes.app.util.json
import com.heroes.app.util.onTextChange
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