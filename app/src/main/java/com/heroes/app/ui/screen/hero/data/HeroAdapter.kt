package com.heroes.app.ui.screen.hero.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.heroes.app.data.api.model.Hero
import com.heroes.app.databinding.HeroListItemBinding
import javax.inject.Inject

class HeroAdapter @Inject constructor() : ListAdapter<Hero, HeroViewHolder>(HeroDiffUtilCallback()) {

  lateinit var callback: (product: Hero) -> Unit

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): HeroViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = HeroListItemBinding.inflate(inflater, parent, false)
    return HeroViewHolder(binding, callback)
  }

  override fun onBindViewHolder(
    holder: HeroViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }
}

