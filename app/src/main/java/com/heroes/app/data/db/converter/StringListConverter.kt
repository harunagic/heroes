package com.heroes.app.data.db.converter

import androidx.room.TypeConverter

class StringListConverter {

  @TypeConverter
  fun fromString(value: String?): ArrayList<String> = when {
    !value.isNullOrEmpty() -> ArrayList(value.split(","))
    else -> ArrayList()
  }

  @TypeConverter
  fun fromArrayList(list: ArrayList<String>?): String? = list?.joinToString(",")
}