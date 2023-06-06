package com.example.hauntedhaven.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.hauntedhaven.HauntedHavenApplication
import com.example.hauntedhaven.data.HauntedDao
import com.example.hauntedhaven.data.HauntedPlace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.example.hauntedhaven.ui.listingCategory



import kotlinx.coroutines.flow.collectLatest


class HauntedViewModel(private val hauntedDao: HauntedDao) : ViewModel() {

    private val _uiState = MutableStateFlow(HauntedUIState())
    val uiState: StateFlow<HauntedUIState> = _uiState.asStateFlow()
    val selectedCategory = MutableStateFlow(listingCategory.All)

    init {
        loadFeaturedHauntedPlaces()

        viewModelScope.launch {
            selectedCategory.collectLatest { category ->
                when (category) {
                    listingCategory.All -> loadAllHauntedPlaces()
                    listingCategory.Prisons -> loadHauntedPlacesByCategory("Prisons")
                    listingCategory.Hospitals -> loadHauntedPlacesByCategory("Hospitals")
                    listingCategory.Hotels -> loadHauntedPlacesByCategory("Hotels")
                    listingCategory.Houses -> loadHauntedPlacesByCategory("Houses")
                    listingCategory.Mansions -> loadHauntedPlacesByCategory("Mansions")
                }
            }
        }
    }

    fun loadAllHauntedPlaces() = viewModelScope.launch {
        hauntedDao.getAll().collect {
            _uiState.value = _uiState.value.copy(hauntedPlaces = it)
        }
    }

    fun loadHauntedPlacesByCategory(category: String) = viewModelScope.launch {
        hauntedDao.getByCategory(category).collect {
            _uiState.value = _uiState.value.copy(hauntedPlaces = it)
        }
    }

    fun loadHauntedPlaceById(id: Int) = viewModelScope.launch {
        hauntedDao.getHauntedPlaceById(id).collect { hauntedPlace ->
            _uiState.value = _uiState.value.copy(hauntedPlace = hauntedPlace)
        }
    }

    private fun loadFeaturedHauntedPlaces() = viewModelScope.launch {
        hauntedDao.getFeatured().collect {
            _uiState.value = _uiState.value.copy(featuredHauntedPlaces = it)
        }
    }

    fun selectCategory(category: listingCategory) {
        selectedCategory.value = category
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HauntedHavenApplication)
                HauntedViewModel(application.database.hauntedDao())
            }
        }
    }
}


data class HauntedUIState(
    val hauntedPlaces: List<HauntedPlace> = emptyList(), //za listing
    val featuredHauntedPlaces: List<HauntedPlace> = emptyList(),  //za homescreen
    val hauntedPlace: HauntedPlace? = null //za detailed

)
