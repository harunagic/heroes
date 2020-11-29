package com.heroes.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heroes.app.di.ViewModelProviderFactory
import com.heroes.app.di.key.ViewModelKey
import com.heroes.app.ui.hero.HeroViewModel
import com.heroes.app.ui.hero_details.HeroDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(HeroViewModel::class)
  abstract fun bindsHeroViewModel(viewModel: HeroViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(HeroDetailsViewModel::class)
  abstract fun bindsHeroDetailsViewModel(viewModel: HeroDetailsViewModel): ViewModel
}