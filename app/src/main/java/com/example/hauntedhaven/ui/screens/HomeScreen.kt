package com.example.hauntedhaven.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hauntedhaven.R
import com.example.hauntedhaven.Screen
import com.example.hauntedhaven.data.HauntedPlace
import com.example.hauntedhaven.ui.theme.BloodRed
import com.example.hauntedhaven.ui.theme.GhostWhite
import com.example.hauntedhaven.ui.theme.MoonlitViolet
import com.example.hauntedhaven.ui.theme.PhantomBlack


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HauntedViewModel = viewModel(factory=HauntedViewModel.factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PhantomBlack)
    ) {
        LazyColumn(
            // modifier = Modifier.fillMaxSize()
        ) {
            item {
                GreetingSection()
                if (uiState.featuredHauntedPlaces.isNotEmpty()) {
                    FeaturedSection(navController = navController, featuredListings = uiState.featuredHauntedPlaces)
                }
                viewAllListings(navController = navController)
            }
        }
    }
}


@Composable
fun FeaturedSection(
    navController: NavController,
    featuredListings: List<HauntedPlace>
) {
    val imageMapper = ImageMapper()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 17.dp, bottom = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Featured listings",
            color = GhostWhite,
            fontSize = 40.sp,
            fontFamily = FontFamily(Font(R.font.gothic)),
            modifier = Modifier.padding(15.dp)
        )

        for (listing in featuredListings) {
            val imageResourceIds = imageMapper.getImageResourceIds(listing.id)
            Box(
                Modifier
                    .clickable { navController.navigate(Screen.DetailedScreen.route + "/${listing.id}") }
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (imageResourceIds.isNotEmpty()) {
                        Image(
                            painter = painterResource(id = imageResourceIds[0]),
                            contentDescription = "Listing Image",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(top = 10.dp, bottom = 10.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .padding(bottom = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            modifier=Modifier
                                .padding(bottom = 15.dp),
                            fontWeight = FontWeight.Bold,
                            text = "${listing.name}",
                            color = GhostWhite,
                            fontFamily = FontFamily(Font(R.font.gothic))
                        )
                        Text(
                            modifier=Modifier.padding(bottom = 15.dp),
                            text = "${listing.location}",
                            fontWeight = FontWeight.Thin,
                            color = GhostWhite,
                            fontFamily = FontFamily(Font(R.font.gothic))
                        )
                        Text(
                            modifier=Modifier
                                .fillMaxWidth()
                                .padding(start = 50.dp)
                                .padding(end = 50.dp),
                            text = "${listing.quick_desc}",
                            color = GhostWhite,
                            fontFamily = FontFamily(Font(R.font.gothic))
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun GreetingSection() {
    Row(
        horizontalArrangement=Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,


        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),


        ) {

        Image(
            painter = painterResource(id = R.drawable.phatonhaven) ,
            contentDescription ="Logo",

            )

    }



}



@Composable
fun viewAllListings(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(17.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "And many more...",
            fontFamily = FontFamily(Font(R.font.gothic)),
            fontSize = 30.sp,
            color= GhostWhite
        )

    }

    Row(
        modifier= Modifier
            .padding(17.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick =
        {
            navController.navigate(Screen.ListingsScreen.route)

        }
            ,colors = ButtonDefaults.buttonColors(BloodRed)) {
            Text(text = "Press to view all listings")

        }

    }


}


