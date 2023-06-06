package com.example.hauntedhaven

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object ListingsScreen: Screen("listing_screen")
    object DetailedScreen: Screen("detailed_screen/{hauntedPlaceId}")

    object SuccessScreen:Screen("success")
}
