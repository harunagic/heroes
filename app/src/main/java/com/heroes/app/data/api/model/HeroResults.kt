package com.heroes.app.data.api.model

import com.google.gson.annotations.SerializedName

data class HeroResults(
  @SerializedName("response")
  val response: String? = null,
  @SerializedName("results")
  val results: List<Hero> = listOf(),
  @SerializedName("results-for")
  val resultsFor: String? = null
)