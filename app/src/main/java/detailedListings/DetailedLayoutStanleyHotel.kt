package detailedListings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hauntedhaven.R
import com.example.hauntedhaven.ui.theme.GhostWhite
import com.example.hauntedhaven.ui.theme.PhantomBlack
import com.example.hauntedhaven.ui.screens.TopBarDetailed

@Composable
fun DetailedLayoutStanleyHotel(
    navController: NavController
) {
    LazyColumn(
        modifier= Modifier.background(PhantomBlack)
    ){
        item {
            TopBarDetailed(title = "Stanley Hotel", navController = navController)
            Row(horizontalArrangement = Arrangement.SpaceBetween
                ,modifier= Modifier
                    .background(PhantomBlack)
                    .fillMaxWidth()
            ) {

                Text(text = ".")

            }
            LazyRow(){
                item {
                    Image(painter = painterResource(id = R.drawable.stanleyhotel0915_maze_92ef1d5afd9445208830d68702895817),
                        contentDescription ="ESP",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.esp2) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.esp3) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.esp4) ,
                        contentDescription ="ESP4",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))
                }
            }
            DescriptionOldStanley()
        }
    }

}



@Composable
fun DescriptionOldStanley() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PhantomBlack)
    ){

        Column() {
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 10.dp),
                text = "Colorado, USA")
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                color = GhostWhite,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 10.dp),
                text = "The Stanley Hotel is a 140-room Colonial Revival hotel in Estes Park, Colorado, United States, about five miles from the entrance to Rocky Mountain National Park. It was built by Freelan Oscar Stanley, co-founder of the Stanley Motor Carriage Company. \n" +
                        "\nThe Stanley Hotel is largely known for being one of the most haunted hotels in the United States, and served as the inspiration for the Overlook Hotel in Stephen King's 1977 bestselling novel The Shining and its 1980 film adaptation. It was also a filming location for the related 1997 TV miniseries. "

            )

        }
    }


}