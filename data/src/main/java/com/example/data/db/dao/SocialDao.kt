package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Social
import kotlinx.coroutines.flow.Flow

@Dao
interface SocialDao {
    @Query("SELECT * from Social")
    fun getSocial(): Flow<List<Social>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSocial(social: List<Social?>)

    @Query("DELETE FROM Social")
    suspend fun deleteSocialList()
}