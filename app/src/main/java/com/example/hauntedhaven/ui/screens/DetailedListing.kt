package com.example.hauntedhaven.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.hauntedhaven.ui.theme.GhostWhite
import com.example.hauntedhaven.ui.theme.PhantomBlack
import com.example.hauntedhaven.ui.screens.TopBarDetailed
@Composable
fun DetailedListing(navController: NavController, hauntedPlaceId: Int, viewModel: HauntedViewModel = viewModel(factory=HauntedViewModel.factory)) {
    val uiState by viewModel.uiState.collectAsState()

    // Load haunted place when the DetailedListing composable is first composed
    LaunchedEffect(hauntedPlaceId) {
        viewModel.loadHauntedPlaceById(hauntedPlaceId)
    }

    val imageMapper = ImageMapper()

    LazyColumn(modifier = Modifier.background(PhantomBlack)) {
        item {
            val hauntedPlace = uiState.hauntedPlace
            if (hauntedPlace != null) {
                TopBarDetailed(title = hauntedPlace.name ?: "No name", navController = navController)

                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.background(PhantomBlack).fillMaxWidth()
                ) {
                    Text(text = ".")
                }

                val imageResourceIds = imageMapper.getImageResourceIds(hauntedPlace.id)
                LazyRow{
                    items(imageResourceIds) { imageResourceId ->
                        Image(
                            painter = painterResource(id = imageResourceId),
                            contentDescription = "Haunted place image",
                            modifier = Modifier.size(400.dp).background(PhantomBlack)
                        )
                    }
                }

                Description(navController = navController,hauntedPlace)
            }
        }
    }
}




@Composable
fun Description(navController: NavController, hauntedPlace: HauntedPlace) {
    Box(modifier = Modifier.fillMaxSize().background(PhantomBlack)) {
        Column() {
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text = hauntedPlace.name ?: "No location"
            )

            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text = hauntedPlace.location ?: "No location"
            )
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                color = GhostWhite,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text = hauntedPlace.desc ?: "No description"
            )

            Spacer(modifier = Modifier.height(30.dp))

            val eventTime: String

            eventTime = if(hauntedPlace.sleep_available==1){
                "10:00PM-6:AM"
            } else{
                "9:00PM-4:AM"
            }

            Column(
                modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Event time: ", fontWeight = FontWeight.Bold, color = GhostWhite)
                    Text(text = "$eventTime", color = GhostWhite)
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = "Event price: ", fontWeight = FontWeight.Bold, color = GhostWhite)
                    Text(text = "${hauntedPlace.price}", color = GhostWhite)
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = "Event date: ", fontWeight = FontWeight.Bold, color = GhostWhite)
                    Text(text = "${hauntedPlace.date}", color = GhostWhite)
                }

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            ) {
                Button(onClick = { navController.navigate(Screen.SuccessScreen.route) }, modifier = Modifier.background(GhostWhite), colors = ButtonDefaults.buttonColors(
                    GhostWhite)) {
                    Text(text="Book now", color = PhantomBlack)
                }
            }




        }
    }
}
