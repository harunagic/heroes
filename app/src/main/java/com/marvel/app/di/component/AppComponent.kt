package com.marvel.app.di.component

import com.marvel.app.App
import com.marvel.app.di.module.ApiModule
import com.marvel.app.di.module.AppModule
import com.marvel.app.di.module.DatabaseModule
import com.marvel.app.di.module.ViewModelModule
import com.marvel.app.ui.screen.hero.HeroFragment
import com.marvel.app.ui.screen.hero_details.HeroDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      DatabaseModule::class,
      ApiModule::class,
      AppModule::class,
      ViewModelModule::class]
)
interface AppComponent {
  fun inject(app: App)
  fun inject(heroFragment: HeroFragment)
  fun inject(heroDetailsFragment: HeroDetailsFragment)
}