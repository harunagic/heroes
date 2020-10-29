package com.marvel.app.di.module

import com.google.gson.Gson
import com.marvel.app.App
import com.marvel.app.R
import com.marvel.app.data.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule constructor(private val app: App) {

  @Singleton
  @Provides
  fun providesApiUrl() = "https://superheroapi.com/api/${app.getString(R.string.heroes_api_key)}/"

  @Singleton
  @Provides
  fun providesHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    httpClient.addInterceptor(logging)
    return httpClient.build()
  }

  @Singleton
  @Provides
  fun providesApiService(
    httpClient: OkHttpClient,
    apiUrl: String
  ): ApiService = Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient)
      .baseUrl(apiUrl)
      .addConverterFactory(GsonConverterFactory.create(Gson()))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
      .create(ApiService::class.java)
}