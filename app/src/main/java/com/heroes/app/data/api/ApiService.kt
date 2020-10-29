package com.heroes.app.data.api

import com.heroes.app.data.api.model.HeroResults
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

  @GET("search/{query}")
  fun getHeroes(@Path(value = "query", encoded = true) name: String): Observable<HeroResults>
}