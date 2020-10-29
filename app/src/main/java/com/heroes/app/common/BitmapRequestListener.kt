package com.heroes.app.common

import android.graphics.Bitmap
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

open class BitmapRequestListener : RequestListener<Bitmap> {

  override fun onResourceReady(
    resource: Bitmap?,
    model: Any?,
    target: Target<Bitmap>?,
    dataSource: DataSource?,
    isFirstResource: Boolean
  ): Boolean {
    resource?.let { resourceLoaded(it) }
    return false
  }

  override fun onLoadFailed(
    e: GlideException?,
    model: Any?,
    target: Target<Bitmap>?,
    isFirstResource: Boolean
  ): Boolean = false

  open fun resourceLoaded(resource: Bitmap) {}
}