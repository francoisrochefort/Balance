package com.example.balance.repo.material

import com.example.balance.data.material.Material
import com.example.balance.data.material.MaterialDao

class MaterialRepositoryImpl(
    private val materialDao: MaterialDao
) : MaterialRepository {
    override suspend fun getMaterialsFromRoom() = materialDao.getMaterials()
    override suspend fun getSearchFromRoom(text: String) = materialDao.getSearch(text)
    override suspend fun getMaterialFromRoom(id: Int) = materialDao.getMaterial(id)

    override suspend fun addMaterialToRoom(material: Material) = materialDao.addMaterial(material)
    override suspend fun updateMaterialInRoom(material: Material) = materialDao.updateMaterial(material)
    override suspend fun deleteMaterialFromRoom(material: Material) = materialDao.deleteMaterial(material)
}
