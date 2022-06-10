package com.example.balance.ui.materials.add_material

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.material.Material
import com.example.balance.repo.material.MaterialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMaterialViewModel @Inject constructor(
    private val repo: MaterialRepository
) : ViewModel() {

    fun addMaterial(material: Material) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addMaterialToRoom(material)
        }
    }
}