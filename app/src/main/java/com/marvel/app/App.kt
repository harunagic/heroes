package com.marvel.app

import android.app.Application
import com.marvel.app.di.component.AppComponent
import com.marvel.app.di.component.DaggerAppComponent
import com.marvel.app.di.module.ApiModule
import com.marvel.app.di.module.AppModule
import com.marvel.app.di.module.DatabaseModule
import timber.log.Timber

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    setupLogging()
    setupDagger()
  }

  private fun setupLogging() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun setupDagger() {
    appComponent = DaggerAppComponent.builder()
        .databaseModule(DatabaseModule(this))
        .apiModule(ApiModule(this))
        .appModule(AppModule(this))
        .build()
    appComponent.inject(this)
  }

  companion object {
    lateinit var appComponent: AppComponent
  }
}