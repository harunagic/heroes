package com.marvel.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marvel.app.di.ViewModelProviderFactory
import com.marvel.app.di.key.ViewModelKey
import com.marvel.app.ui.screen.hero.HeroViewModel
import com.marvel.app.ui.screen.hero_details.HeroDetailsViewModel
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