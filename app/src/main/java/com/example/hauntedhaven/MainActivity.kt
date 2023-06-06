package com.example.hauntedhaven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hauntedhaven.ui.theme.HauntedHavenTheme
import com.example.hauntedhaven.ui.screens.HomeScreen

import com.example.hauntedhaven.ui.nav.SetupNavGraph
import com.example.hauntedhaven.ui.screens.HauntedViewModel
import com.example.hauntedhaven.ui.screens.ListingsPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HauntedHavenTheme {
                val navController = rememberNavController()
                val viewModel: HauntedViewModel = viewModel(factory = HauntedViewModel.factory)
                SetupNavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}



