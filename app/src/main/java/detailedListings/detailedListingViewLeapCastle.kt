package detailedListings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun DetailedLayoutLeapCastle(
    navController: NavController
) {
    LazyColumn(
        modifier=Modifier.background(PhantomBlack)
    ){
        item {
            TopBarDetailed(title = "Leap Castle", navController = navController)

            LazyRow(){
                item {
                    Image(painter = painterResource(id = R.drawable.leap_website),
                        contentDescription ="ESP",
                    modifier= Modifier
                        .size(400.dp)
                        .background(PhantomBlack))
                    
                    Image(painter = painterResource(id = R.drawable.leap2) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.leap3) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))


                }
            }
            DescriptionLeapCastle()
        }
    }

}



@Composable
fun DescriptionLeapCastle() {
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
                text = "Location: Ireland")
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                color = GhostWhite,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 10.dp),
                text = "One of the most terrifying places in all of Pennsylvania must be Eastern State Penitentiary. This was the first penitentiary in the United States and it was designed specifically with the intention of placing prisoners in a situation where they spent time silently reflecting on their crimes without interaction with other people.\n" +
                        "\n" +
                        "Those incarcerated in this prison were subjected to both physical and psychological torture. Some of the famous methods used here included the ‘Mad Chair’ where prisoners would be strapped tightly in and be left sitting completely motionless for days without food and water – often driving them to insanity.\n" +
                        "\n" +
                        "Other methods included clamping their tongue with the ‘Iron Gag’ which would cause severe pain and bleeding if they tried to speak, and throwing prisoners into ‘The Hole’ where they could be kept in a dark pit for weeks at a time.\n" +
                        "\n" +
                        "Needless to say, many men held here went completely insane and many of them died. It is no surprise that visitors hear footsteps, screams, moans, and other unexplained noises."

            )
            
        }
    }
    
    
}




    







