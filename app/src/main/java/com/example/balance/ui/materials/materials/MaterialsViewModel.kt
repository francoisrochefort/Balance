package com.example.balance.ui.materials.materials

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.material.Material
import com.example.balance.repo.material.MaterialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MaterialsViewModel @Inject constructor(
    private val repo: MaterialRepository
) : ViewModel() {

    var materials by mutableStateOf(emptyList<Material>())
    var search by mutableStateOf(emptyList<Material>())

    fun getMaterials() {
        viewModelScope.launch {
            repo.getMaterialsFromRoom().collect { response ->
                materials = response
            }
        }
    }

    fun getSearch(text: String) {
        viewModelScope.launch {
            repo.getSearchFromRoom(text).collect { response ->
                search = response
            }
        }
    }

    fun deleteMaterial(material: Material) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteMaterialFromRoom(material)
        }
    }
}