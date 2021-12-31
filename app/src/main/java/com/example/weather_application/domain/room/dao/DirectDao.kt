package com.example.weather_application.domain.room.dao

import androidx.room.*
import com.example.weather_application.domain.room.entites.DirectEntity


@Dao
interface DirectDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirect(directEntity: DirectEntity)

    @Delete
    suspend fun delete(directEntity: DirectEntity)

    @Query("SELECT * FROM directs")
    suspend fun getDirects(): MutableList<DirectEntity>
}