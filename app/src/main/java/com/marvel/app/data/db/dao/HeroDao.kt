package com.marvel.app.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marvel.app.data.db.entity.HeroEntity
import io.reactivex.Observable

@Dao
interface HeroDao {

  @Query("SELECT * from heroes WHERE name LIKE '%' || :query || '%' ORDER BY name ASC")
  fun getByName(query: String): Observable<List<HeroEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(data: List<HeroEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(data: HeroEntity)

  @Update
  fun update(data: HeroEntity)

  @Delete
  fun delete(data: HeroEntity)

  @Query("DELETE FROM heroes")
  fun deleteAll()
}