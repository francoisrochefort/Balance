package com.example.balance.repo.material

import com.example.balance.data.material.Material
import kotlinx.coroutines.flow.Flow

interface MaterialRepository {
    suspend fun getMaterialsFromRoom(): Flow<List<Material>>
    suspend fun getSearchFromRoom(text: String): Flow<List<Material>>
    suspend fun getMaterialFromRoom(id: Int): Flow<Material>

    suspend fun addMaterialToRoom(material: Material, replace: Boolean) : Long
    suspend fun updateMaterialInRoom(material: Material)
    suspend fun deleteMaterialFromRoom(material: Material)
}