package com.heroes.app.di.component

import com.heroes.app.App
import com.heroes.app.di.module.ApiModule
import com.heroes.app.di.module.AppModule
import com.heroes.app.di.module.DatabaseModule
import com.heroes.app.di.module.ViewModelModule
import com.heroes.app.ui.hero.HeroFragment
import com.heroes.app.ui.hero_details.HeroDetailsFragment
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