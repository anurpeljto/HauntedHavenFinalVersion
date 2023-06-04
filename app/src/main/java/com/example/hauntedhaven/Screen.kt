package com.example.hauntedhaven

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object ListingsPage: Screen("listing_screen")

    object DetailedScreen:Screen("detailed_screen")

    object DetailedScreenLeap:Screen("leap_castle")

    object DetailedScreenGables:Screen("house_of_gables")

    object DetailedScreenChangi:Screen("changi")

    object DetailedScreenTowerOfLondon:Screen("tower_of_london")

    object DetailedScreenStanleyHotel:Screen("stanley_hotel")

    object DetailedScreenAlbansHospital:Screen("albans_hospital")

    object DetailedScreenChillingham:Screen("chillingham_castle")
}
