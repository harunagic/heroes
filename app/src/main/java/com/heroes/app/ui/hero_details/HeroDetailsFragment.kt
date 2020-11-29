package com.heroes.app.ui.hero_details

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.heroes.app.BR
import com.heroes.app.R
import com.heroes.app.data.api.model.Hero
import com.heroes.app.databinding.HeroDetailsFragmentBinding
import com.heroes.app.di.component.AppComponent
import com.heroes.app.ui.base.BaseFragment
import com.heroes.app.util.fromJson

class HeroDetailsFragment : BaseFragment<HeroDetailsFragmentBinding, HeroDetailsViewModel>(R.layout.hero_details_fragment) {

  private val args: HeroDetailsFragmentArgs by navArgs()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun inject(appComponent: AppComponent) {
    appComponent.inject(this)
  }

  override fun getViewModel(factory: Factory): HeroDetailsViewModel = ViewModelProvider(this, factory).get(HeroDetailsViewModel::class.java)
  override fun getBindingVariable(): Int = BR.viewModel

  override fun setupUI() {
    val hero = args.hero.fromJson<Hero>()

    // Info
    dataBinding.hero = hero

    // Poster image
    Glide.with(this)
        .load(hero.image?.url)
        .into(dataBinding.imgPoster)

    // Cover image
    Glide.with(this)
        .load(hero.image?.url)
        .into(dataBinding.imgCover)

    // Aliases
    hero.biography?.aliases?.forEach {
      val chip = Chip(context)
      chip.text = it
      dataBinding.groupAliases.addView(chip)
    }
  }

  override fun setupListeners() {
    dataBinding.toolbar.setNavigationOnClickListener {
      findNavController().navigateUp()
    }

    dataBinding.toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.btnShare -> {
          Toast.makeText(context, "Share function is not implemented :(", Toast.LENGTH_SHORT).show()
          true
        }
        else -> false
      }
    }
  }
}