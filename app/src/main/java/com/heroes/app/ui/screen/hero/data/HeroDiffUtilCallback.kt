package com.heroes.app.ui.screen.hero.data

import androidx.recyclerview.widget.DiffUtil
import com.heroes.app.data.api.model.Hero

class HeroDiffUtilCallback : DiffUtil.ItemCallback<Hero>() {
  override fun areItemsTheSame(
    oldItem: Hero,
    newItem: Hero
  ): Boolean = oldItem.id == newItem.id

  override fun areContentsTheSame(
    oldItem: Hero,
    newItem: Hero
  ): Boolean = oldItem.name == newItem.name
}