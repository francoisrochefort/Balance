package com.example.balance.data.material

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MaterialDao {
    @Query("SELECT * FROM materials ORDER BY name ASC")
    fun getMaterials(): Flow<List<Material>>

    @Query("SELECT * FROM materials WHERE name LIKE :text || '%' ORDER BY name ASC")
    fun getSearch(text: String): Flow<List<Material>>

    @Query("SELECT * FROM materials WHERE id = :id")
    fun getMaterial(id: Int): Flow<Material>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMaterial(material: Material)

    @Update
    fun updateMaterial(material: Material)

    @Delete
    fun deleteMaterial(material: Material)
}

