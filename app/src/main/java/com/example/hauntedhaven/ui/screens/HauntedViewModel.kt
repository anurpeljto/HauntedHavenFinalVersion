package com.example.hauntedhaven.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.hauntedhaven.HauntedHavenApplication

import com.example.hauntedhaven.data.HauntedDao
import com.example.hauntedhaven.data.HauntedPlace
import kotlinx.coroutines.flow.Flow

class HauntedViewModel(private val hauntedDao: HauntedDao): ViewModel() {
    // Get full haunted places list from Room DB


    fun getAllHauntedPlaces(): Flow<List<HauntedPlace>> = hauntedDao.getAll()

    // Get featured haunted places from Room DB
    fun getFeaturedHauntedPlaces(): Flow<List<HauntedPlace>> = hauntedDao.getFeatured()

    // Get haunted places by category from Room DB
    fun getHauntedPlacesByCategory(category: String): Flow<List<HauntedPlace>> =
        hauntedDao.getByCategory(category)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as HauntedHavenApplication)
                HauntedViewModel(application.database.hauntedDao())
            }
        }
    }
}