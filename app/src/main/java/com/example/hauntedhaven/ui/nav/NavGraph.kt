package com.example.hauntedhaven.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hauntedhaven.Screen
import com.example.hauntedhaven.ui.screens.DetailedListing
import com.example.hauntedhaven.ui.screens.HauntedViewModel
import com.example.hauntedhaven.ui.screens.HomeScreen
import com.example.hauntedhaven.ui.screens.ListingsPage
import com.example.hauntedhaven.ui.screens.SuccessPage

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: HauntedViewModel = viewModel(factory=HauntedViewModel.factory)
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController=navController, viewModel = viewModel)
        }

        composable(route = Screen.ListingsScreen.route){
            ListingsPage(navController = navController, viewModel = viewModel)
        }

        composable(route = "${Screen.DetailedScreen.route}/{hauntedPlaceId}") { backStackEntry ->
            val hauntedPlaceId = backStackEntry.arguments?.getString("hauntedPlaceId")?.toIntOrNull()
            if (hauntedPlaceId != null) {
                DetailedListing(navController = navController, hauntedPlaceId = hauntedPlaceId, viewModel = viewModel)
            } else {

            }
        }

        composable(route=Screen.SuccessScreen.route){
            SuccessPage(navController = navController)
        }

    }
}
/*

@Composable
fun SetupNavGraph2(
    navController: NavHostController,
    viewModel: HauntedViewModel
) {
    NavHost(
        navController =navController ,
        startDestination = Screen.ListingsScreen.route){
        composable(route = Screen.ListingsScreen.route){
            ListingsPage(modifier= Modifier,navController=navController, viewModel = viewModel)


        }
        composable(route = Screen.DetailedScreen.route){
            DetailedLayout(navController = navController)
        }
    }
    
}



 */