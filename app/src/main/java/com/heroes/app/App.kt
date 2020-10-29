package com.heroes.app

import android.app.Application
import com.heroes.app.di.component.AppComponent
import com.heroes.app.di.component.DaggerAppComponent
import com.heroes.app.di.module.ApiModule
import com.heroes.app.di.module.AppModule
import com.heroes.app.di.module.DatabaseModule
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