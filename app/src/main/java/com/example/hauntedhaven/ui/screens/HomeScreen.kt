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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    viewModel: HauntedViewModel

) {
    val featuredListings by viewModel.getFeaturedHauntedPlaces().collectAsState(emptyList())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PhantomBlack)

    ) {
        LazyColumn() {
            item {
                GreetingSection();
                FeaturedSection(navController=navController, featuredListings = featuredListings);
                viewAllListings(navController = navController)
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
            painter = painterResource(id = R.drawable.logohh2) ,
            contentDescription ="Logo",

        )

    }



    }





@Composable
fun FeaturedSection(
    navController: NavController,
    featuredListings: List<HauntedPlace>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 17.dp)
            .padding(bottom = 17.dp),
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
            /*
            Image(
                painter = painterResource(id = getDrawableResourceByName(listing.img)),
                contentDescription = listing.names,
                modifier = Modifier
                    .size(150.dp)
                    .clickable { navController.navigate(Screen.DetailedScreenLeap.route) }
            )

             */

            Text(
                text = "Name: ${listing.names}",
                color = GhostWhite,
                fontFamily = FontFamily(Font(R.font.gothic)),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { navController.navigate(Screen.DetailedScreenLeap.route) }
            )
            Text(
                text = "Location: ${listing.locations}",
                color = GhostWhite,
                fontFamily = FontFamily(Font(R.font.gothic)),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { navController.navigate(Screen.DetailedScreenLeap.route) }
            )
            Text(
                text = "Price: $${listing.current_price}",
                color = GhostWhite,
                fontFamily = FontFamily(Font(R.font.gothic)),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { navController.navigate(Screen.DetailedScreenLeap.route) }
            )
            Text(
                text = "Description: ${listing.quick_description}",
                color = GhostWhite,
                fontFamily = FontFamily(Font(R.font.gothic)),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { navController.navigate(Screen.DetailedScreenLeap.route) }
            )
        }
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
        navController.navigate(Screen.ListingsPage.route)

        }
            ,colors = ButtonDefaults.buttonColors(BloodRed)) {
            Text(text = "Press to view all listings")

        }

    }


}


