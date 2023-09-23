package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.R
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.primaryTextColor
import com.journeyai.glimpse.ui.theme.secondaryText

@Composable
fun Profile() {
    val navController = LocalNavigatorProvider.current
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 48.dp)
                    .width(64.dp)
                    .height(64.dp),
                painter = painterResource(id = R.drawable.alex),
                contentDescription = null
            )
        }
        Text(
            "Alex", style = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        Text(
            "Joined Sept 16, 2023", style = TextStyle(fontSize = 14.sp, color = secondaryText),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp)
        )

        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
            thickness = 1.dp,
            color = borderColor
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp)
                    .width(64.dp)
                    .height(64.dp)
                    .clickable {
                        navController.navigate("categories")

                    },
                painter = painterResource(id = R.drawable.settings),
                contentDescription = null
            )
        }
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end= 16.dp, top = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(width = 1.dp, color = borderColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Text(
                    "Hi Alex, make your trip memorable!",
                    style = TextStyle(fontSize = 18.sp, color = primaryTextColor),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp)
                )
                Button(
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 24.dp),
                    onClick = {
                        navController.navigate("destination")
                    },
                ) {
                    Text("Start My Journal")
                }
            }
        }

    }


}