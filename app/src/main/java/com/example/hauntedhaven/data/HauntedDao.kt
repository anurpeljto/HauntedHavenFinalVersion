package com.example.hauntedhaven.data

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HauntedDao {


    @Query("SELECT * FROM HauntedPlace")
    fun getAll(): Flow<List<HauntedPlace>>


    @Query("SELECT * FROM HauntedPlace ORDER BY RANDOM() LIMIT 5")
    fun getFeatured(): Flow<List<HauntedPlace>>


    @Query("SELECT * FROM HauntedPlace WHERE category = :category")
    fun getByCategory(category: String): Flow<List<HauntedPlace>>

    @Query("SELECT * FROM HauntedPlace WHERE id = :id")
    fun getHauntedPlaceById(id: Int): Flow<HauntedPlace>


}