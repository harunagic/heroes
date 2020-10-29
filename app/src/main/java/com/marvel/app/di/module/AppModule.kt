package com.marvel.app.di.module

import com.marvel.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

  @Provides
  @Singleton
  internal fun providesApp(): App = app
}