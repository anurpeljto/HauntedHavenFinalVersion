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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hauntedhaven.R
import com.example.hauntedhaven.Screen
import com.example.hauntedhaven.data.HauntedPlace
import com.example.hauntedhaven.ui.listingCategory

import com.example.hauntedhaven.ui.theme.*





@Composable
fun ListingsPage(modifier: Modifier = Modifier, navController: NavController, viewModel: HauntedViewModel = viewModel(factory = HauntedViewModel.factory)) {
    val uiState by viewModel.uiState.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    Box(modifier = Modifier.background(PhantomBlack)) {
        Column {
            TopBar(title = "Listings", navController = navController)
            HorizontalScroll( viewModel = viewModel)

            LazyColumn(modifier = Modifier.padding(horizontal = 17.dp)) {
                val filteredHauntedPlaces = if (selectedCategory == listingCategory.All) {
                    uiState.hauntedPlaces
                } else {
                    uiState.hauntedPlaces.filter { it.category == selectedCategory.name }
                }


                items(filteredHauntedPlaces) { hauntedPlace ->
                    ListingItem(hauntedPlace, modifier, navController)
                }
            }
        }
    }

    // Load all haunted places when the ListingsPage composable is first composed
    LaunchedEffect(Unit) {
        viewModel.loadAllHauntedPlaces()
    }
}


@Composable
fun ListingItem(listing: HauntedPlace, modifier: Modifier = Modifier, navController: NavController) {
    val imageMapper = ImageMapper()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate(Screen.DetailedScreen.route + "/${listing.id}")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Show the first image of the listing
            val imageResourceIds = imageMapper.getImageResourceIds(listing.id)
            if (imageResourceIds.isNotEmpty()) {
                Image(
                    painter = painterResource(id = imageResourceIds[0]),
                    contentDescription = "Listing Image",
                    modifier = Modifier
                        .size(96.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = listing.name ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp, bottom = 30.dp),
                    color = Color.White
                )
                Text(
                    text = listing.location ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )

                Text(
                    text = "Price: ${listing.price}",
                    color = GhostWhite,
                    fontFamily = FontFamily(Font(R.font.gothic))
                )
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
                IconButton(
                    onClick = { expandedState.value = !expandedState.value },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hamburger_icon_svg),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(30.dp)
                            .background(GhostWhite)
                    )
                    DropdownMenu(
                        expanded = expandedState.value,
                        onDismissRequest = { expandedState.value = false },
                        modifier = Modifier.background(
                            GhostWhite
                        )
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Home", color = PhantomBlack) },
                            onClick = { navController.navigate(Screen.HomeScreen.route) })
                        DropdownMenuItem(
                            text = { Text(text = "Listings", color = PhantomBlack) },
                            onClick = { navController.navigate(Screen.ListingsScreen.route) })
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
                IconButton(
                    onClick = { expandedState.value = !expandedState.value },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pngkey_com_back_arrow_png_1910559),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(30.dp)
                            .background(GhostWhite)
                            .clickable { navController.navigate(Screen.ListingsScreen.route) }
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


@Composable
fun HorizontalScroll(viewModel: HauntedViewModel) {
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    LazyRow(modifier = Modifier.padding(8.dp)) {
        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.All) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.All) Purple40 else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "All", fontSize = 15.sp)
            }
        }

        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.Prisons) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.Prisons) BloodRed else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Prisons", fontSize = 15.sp)
            }
        }

        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.Hospitals) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.Hospitals) halloweenOrange else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Hospitals", fontSize = 15.sp)
            }
        }

        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.Hotels) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.Hotels) Color.DarkGray else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Hotels", fontSize = 15.sp)
            }
        }

        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.Houses) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.Houses) MoonlitViolet else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Houses", fontSize = 15.sp)
            }
        }

        item {
            Button(
                onClick = { viewModel.selectCategory(listingCategory.Mansions) },
                colors = ButtonDefaults.buttonColors(if (selectedCategory == listingCategory.Mansions) PurpleGrey40 else MistyGrey),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Mansions", fontSize = 15.sp)
            }
        }
    }
}
