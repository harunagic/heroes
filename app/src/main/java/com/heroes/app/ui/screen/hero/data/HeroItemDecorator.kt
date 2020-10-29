package com.heroes.app.ui.screen.hero.data

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State

class HeroItemDecorator : RecyclerView.ItemDecoration() {

  private var spanCount = 2
  private var spacing = 30

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: State
  ) {
    val position = parent.getChildAdapterPosition(view)
    val column = position % spanCount
    outRect.left = spacing - column * spacing / spanCount
    outRect.right = (column + 1) * spacing / spanCount
    if (position < spanCount) {
      outRect.top = spacing + 200
    }
    outRect.bottom = spacing
  }
}