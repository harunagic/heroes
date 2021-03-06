package com.heroes.app.di.module

import androidx.room.Room
import com.heroes.app.App
import com.heroes.app.data.db.HeroDatabase
import com.heroes.app.data.db.dao.HeroDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule constructor(private val app: App) {

  @Singleton
  @Provides
  fun providesHeroDatabase(): HeroDatabase =
    Room.databaseBuilder(app, HeroDatabase::class.java, "heroes-db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

  @Provides
  @Singleton
  fun providesHeroDao(heroDatabase: HeroDatabase): HeroDao = heroDatabase.heroDao()
}