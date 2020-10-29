package com.marvel.app.data.api.model

import com.google.gson.annotations.SerializedName
import com.marvel.app.data.api.model.Hero

data class HeroResults(
  @SerializedName("response")
  val response: String? = null,
  @SerializedName("results")
  val results: List<Hero> = listOf(),
  @SerializedName("results-for")
  val resultsFor: String? = null
)