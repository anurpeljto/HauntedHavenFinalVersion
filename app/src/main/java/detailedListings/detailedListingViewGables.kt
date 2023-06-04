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
fun DetailedLayoutGables(
    navController: NavController
) {
    Box(
        modifier = Modifier.background(PhantomBlack).fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.background(PhantomBlack)
        ) {
            item {
                TopBarDetailed(
                    title = "House of Gables",
                    navController = navController
                )
                LazyRow() {

                    item {

                        Image(
                            painter = painterResource(id = R.drawable.gables2),
                            contentDescription = "ESP",
                            modifier = Modifier
                                .size(400.dp)
                                .background(PhantomBlack)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.gables3),
                            contentDescription = "ESP3",
                            modifier = Modifier
                                .size(400.dp)
                                .background(PhantomBlack)
                        )


                    }
                }
                DescriptionGables()
            }
        }

    }
}



@Composable
fun DescriptionGables() {
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
                text = "Location: Massachusetts")
            Text(
                fontFamily = FontFamily(Font(R.font.gothic)),
                color = GhostWhite,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 10.dp),
                text = "The House of the Seven Gables (also known as the Turner House or Turner-Ingersoll Mansion) is a 1668 colonial mansion in Salem, Massachusetts, named for its gables. It was made famous by Nathaniel Hawthorne's 1851 novel The House of the Seven Gables."

            )

        }
    }


}




    







