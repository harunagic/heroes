package com.marvel.app.data.mapper

import com.marvel.app.data.api.model.Hero
import com.marvel.app.data.api.model.Image
import com.marvel.app.data.db.entity.HeroEntity
import javax.inject.Inject

class HeroMapper @Inject constructor(
  private val biographyMapper: BiographyMapper
) {

  fun toEntities(data: List<Hero>) = data.map { toEntity(it) }

  fun toEntity(data: Hero) = HeroEntity(
      id = data.id,
      name = data.name,
      imageUrl = data.image?.url,
      biography = biographyMapper.toEntity(data.biography)
  )

  fun toModels(data: List<HeroEntity>) = data.map { toModel(it) }

  fun toModel(data: HeroEntity) = Hero(
      id = data.id,
      name = data.name,
      image = Image(url = data.imageUrl),
      biography = biographyMapper.toModel(data.biography)
  )
}