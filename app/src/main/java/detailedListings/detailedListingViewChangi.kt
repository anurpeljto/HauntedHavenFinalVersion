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
fun DetailedLayoutChangi(
    navController: NavController
) {
    LazyColumn(
        modifier=Modifier.background(PhantomBlack)
    ){
        item {
            TopBarDetailed(
                title = "Old Changi",
                navController = navController
            )
//comment to fix git
            LazyRow(){
                item {
                    Image(painter = painterResource(id = R.drawable.hauntedchangi_main),
                        contentDescription ="ESP",
                    modifier= Modifier
                        .size(400.dp)
                        .background(PhantomBlack))
                    
                    Image(painter = painterResource(id = R.drawable.hauntedchangi2) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.hauntedchangi3) ,
                        contentDescription ="ESP3",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))

                    Image(painter = painterResource(id = R.drawable.hauntedchangi4) ,
                        contentDescription ="ESP4",
                        modifier= Modifier
                            .size(400.dp)
                            .background(PhantomBlack))
                }
            }
            DescriptionChangi()
        }
    }

}



@Composable
fun DescriptionChangi() {
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
                text = "Location: Singapore")
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                color = GhostWhite,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 10.dp),
                text = " Old Changi Hospital in Singapore is one of the most notoriously haunted places in the world.  \n" +
                        "\n" +
                        "    During World War II, Japanese forces invaded Singapore and the beaches of Changi were soaked in the blood beheaded civilians and prisoners of war.  The Japanese military took the original Changi buildings and made it their headquarters.  There were many rumors of horrific torture chambers and the bloody executions of POWs.  After the war, the Japanese themselves became the executed and paid for their war crimes with their own blood in the same Changi area.\n" +
                        "\n" +
                        "    In the 1950's the former military barracks were turned into a public hospital.  A perpetual portal for life and death, the premises was proclaimed haunted by the public throughout the years.  Witnesses claimed to see ghosts, Japanese soldiers and even pontianaks -- a Malay vampire.  Some locals even believed that suffering through a serious injury was better than going to the haunted Changi hospital for medical attention.\n" +
                        "\n" +
                        "    In 1994, the original Changi Hospital moved its location.  The buildings have been abandoned ever since 1997, only to be vandalized by those who dare enter.  It's been reported that some explorers never come back out.  But for Singapore thrill-seekers, the attraction to Old Changi Hospital is always there.\n" +
                        "\n" +
                        "    Spirits of different races and nationalities have been reported wandering around the premises."

            )
            
        }
    }
    
    
}




    







