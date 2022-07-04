package com.example.balance.ui.materials.add_material

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.customer.Customer
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

    var material by mutableStateOf(Material(""))
        private set

    fun updateName(name: String) {
        material = material.copy(name = name)
    }

    fun addMaterial() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addMaterialToRoom(material)
        }
    }
}