package com.example.hauntedhaven.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hauntedhaven.Screen
import com.example.hauntedhaven.ui.theme.GhostWhite
import com.example.hauntedhaven.ui.theme.PhantomBlack

@Composable
fun SuccessPage(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PhantomBlack),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.size(64.dp)
            )
            Text(
                text = "Success!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = GhostWhite,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text(
                text = "Enjoy your stay!",
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(GhostWhite),
                onClick = { navController.navigate(Screen.HomeScreen.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Return to home", color = PhantomBlack)
            }
        }

    }
}
