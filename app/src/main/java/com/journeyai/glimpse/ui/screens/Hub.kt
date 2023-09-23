package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyai.glimpse.R
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.primaryTextColor
import com.journeyai.glimpse.ui.theme.secondaryText

@Composable
fun Hub() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Find your fellows!",
            style = TextStyle(
                fontSize = 28.sp,
                color = primaryTextColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(200.dp),
            painter = painterResource(id = R.drawable.paris),
            contentDescription = null
        )
        Text(
            "Paris",
            style = TextStyle(
                fontSize = 18.sp,
                color = primaryTextColor,
            ),
            modifier = Modifier
                .padding(top = 14.dp)
        )

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 4.dp, end = 4.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(width = 1.dp, color = borderColor)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp),
                    painter = painterResource(id = R.drawable.card_avatar1),
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        "Nicolas",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = primaryTextColor,
                        ),
                    )
                    Text(
                        "wrote here on 09.10.23",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = secondaryText,
                        ),
                        modifier = Modifier
                            .padding(top = 4.dp)
                    )
                }

            }
        }
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 4.dp, end = 4.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(width = 1.dp, color = borderColor)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp),
                    painter = painterResource(id = R.drawable.card_avatar2),
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        "Anna",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = primaryTextColor,
                        ),
                    )
                    Text(
                        "wrote here on 08.29.233",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = secondaryText,
                        ),
                        modifier = Modifier
                            .padding(top = 4.dp)
                    )
                }

            }
        }
    }

}