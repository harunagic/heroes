package com.heroes.app.ui.screen.hero.data

import android.graphics.Bitmap
import android.graphics.Color
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.heroes.app.common.BitmapRequestListener
import com.heroes.app.data.api.model.Hero
import com.heroes.app.databinding.HeroListItemBinding

class HeroViewHolder(
  private val binding: HeroListItemBinding,
  private val callback: (product: Hero) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(data: Hero) {
    // Click listener
    binding.root.setOnClickListener { callback(data) }

    // Info
    binding.hero = data

    // Picture
    Glide.with(itemView.context)
        .asBitmap()
        .load(data.image?.url)
        .centerCrop()
        .transition(BitmapTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .addListener(object : BitmapRequestListener() {
          override fun resourceLoaded(resource: Bitmap) {
            val palette = Palette.from(resource)
            palette.generate {
              val bgColor = it?.getMutedColor(Color.BLACK) ?: 0
              binding.txtName.setBackgroundColor(bgColor)
            }
          }
        })
        .into(binding.imgHero)
  }
}