package com.marvel.app.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marvel.app.data.api.model.Hero
import com.marvel.app.ui.screen.hero.data.HeroAdapter

@BindingAdapter("app:isVisible")
fun bindVisibility(
  view: View,
  visible: Boolean
) {
  view.visibility = when {
    visible -> View.VISIBLE
    else -> View.GONE
  }
}

@BindingAdapter("app:bindHeroes")
fun bindHeroes(
  view: RecyclerView,
  items: List<Hero>?
) {
  val adapter = view.adapter
  if (adapter is HeroAdapter && items != null) {
    adapter.submitList(items)
    view.post { view.scrollToPosition(0) }
  }
}