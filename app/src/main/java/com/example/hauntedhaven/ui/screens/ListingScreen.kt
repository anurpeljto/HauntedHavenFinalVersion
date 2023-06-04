package com.example.hauntedhaven.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hauntedhaven.R
import com.example.hauntedhaven.Screen
import com.example.hauntedhaven.ui.theme.GhostWhite
import com.example.hauntedhaven.ui.theme.HauntedHavenTheme
import com.example.hauntedhaven.ui.Listing
import com.example.hauntedhaven.ui.theme.PhantomBlack
import com.example.hauntedhaven.ui.listingCategory


@Composable
fun ListingsPage(modifier: Modifier = Modifier, navController: NavController){
    val hauntedHaven = painterResource(id =R.drawable.screenshot_2023_05_28_at_20_30_06)
    val listings = listOf(
        Listing("Eastern State Penitentiary", "Pennsylvania, USA", image = R.drawable.eastern_state_penitentiary__philadelphia__pennsylvania_lccn2011632222_tif, listingCategory.PENITENTIARY_PHANTOMS,routee="detailed_screen"),
        Listing("Leap Castle","Ireland", image = R.drawable.leap_website,
            listingCategory.CASTLES_MANSIONS,routee="leap_castle"),
        Listing("House of the seven gables","Massachusetts", image = R.drawable.llhouseof7gables_jpg,
            listingCategory.HOUSES,"house_of_gables"),
        Listing("The old Changi hospital","Singapore,Singapore", image = R.drawable.hauntedchangi_main,
            listingCategory.SCHOOLS_HOSPITALS,"changi"),
        Listing("The old tower of London","London, United Kingdom",image=R.drawable.keep_white_tower_jpg,
            listingCategory.CASTLES_MANSIONS,"tower_of_london"),
        Listing("Stanley Hotel","Colorado, USA", image = R.drawable.stanleyhotel0915_maze_92ef1d5afd9445208830d68702895817,
            listingCategory.HOTELS,"stanley_hotel"),
        Listing("St. Albans Hospital","Virginia,USA", image = R.drawable._77_0046_stalbanshospital_2019_exterior_front_elevation_vlr_online,
            listingCategory.SCHOOLS_HOSPITALS,"albans_hospital"),
        Listing("Chillingham Castle","Chillingham, United Kingdom", image = R.drawable.chillingham_castle_stormy_external_1442x760,
            listingCategory.CASTLES_MANSIONS,"chillingham_castle")
        )

    Box(
        modifier = Modifier.background(PhantomBlack)
    ) {
        Column(

        ) {
            TopBar(title = "Listings", navController = navController)
            LazyColumn(modifier = Modifier.padding(horizontal = 17.dp)) {
                items(listings) { listing ->
                    ListingItem(listing, navController = navController)


                }

            }
        }

    }
}

@Composable
fun ListingItem(listing: Listing, modifier: Modifier = Modifier, navController: NavController) {
    val painter = painterResource(id = listing.image)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .clickable { navController.navigate(listing.routee) },
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clickable { navController.navigate(listing.routee) }
            ) {
                Row {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = listing.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp, bottom = 30.dp),
                            color = Color.White
                        )
                        Text(
                            text = listing.location,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun TopBar(
        title: String,
        modifier: Modifier = Modifier,
        navController: NavController
) {
    val expandedState = remember { mutableStateOf(false) }
    Box(
            Modifier.fillMaxWidth()
    ) {

        Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GhostWhite)
                    .height(70.dp)
        ) {
            IconButton(onClick = { expandedState.value = !expandedState.value },
                    modifier = Modifier.align(Alignment.CenterStart)) {
                Image(
                        painter = painterResource(id = R.drawable.hamburger_icon_svg),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(30.dp)
                            .background(GhostWhite)
                )
                DropdownMenu(expanded = expandedState.value, onDismissRequest = { expandedState.value = false }, modifier = Modifier.background(
                        GhostWhite
                )) {
                    DropdownMenuItem(text = { Text(text = "Home", color = PhantomBlack) }, onClick = { navController.navigate(Screen.HomeScreen.route) })
                    DropdownMenuItem(text = { Text(text = "Listings", color = PhantomBlack)}, onClick = { navController.navigate(Screen.ListingsPage.route) })
                }
            }

            Image(
                    painter = painterResource(id = R.drawable.hauntedghostwhite),
                    contentDescription = "logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(900.dp)
            )

        }

    }
}


@Composable
fun TopBarDetailed(
    title: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val expandedState = remember { mutableStateOf(false) }
    Column(
        Modifier.background(PhantomBlack)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GhostWhite)
                .height(70.dp)
        ) {
            IconButton(onClick = { expandedState.value = !expandedState.value },
                modifier = Modifier.align(Alignment.CenterStart)) {
                Image(
                    painter = painterResource(id = R.drawable.pngkey_com_back_arrow_png_1910559),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(30.dp)
                        .background(GhostWhite)
                        .clickable { navController.navigate(Screen.ListingsPage.route) }
                )
            }

            Image(
                painter = painterResource(id = R.drawable.hauntedghostwhite),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(1000.dp)
            )

        }

    }
}





@Preview(showBackground = true)
@Composable
fun ListingPreview() {
    HauntedHavenTheme {
        ListingsPage(navController = rememberNavController())

    }
}