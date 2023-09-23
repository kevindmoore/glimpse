package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyai.glimpse.LocalDataProvider
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.R
import com.journeyai.glimpse.models.ChipInfo
import com.journeyai.glimpse.models.ImageCategoryRequest
import com.journeyai.glimpse.network.RetrofitInstance
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.primaryTextColor

@Composable
fun Photos() {
    val navController = LocalNavigatorProvider.current
    val currentData = LocalDataProvider.current
    val categoryChips = remember { mutableListOf<ChipInfo>() }
    LaunchedEffect(Unit) {
/*
        val aiService = RetrofitInstance.aiService
        val response =
            RetrofitInstance.imageCategories(ImageCategoryRequest("1", "2023-09-15", "2023-09-20"))
        if (response.data.isNotEmpty()) {
            currentData.currentImageCategoryResponse = response
            response.data.forEach {

            }
        }
*/
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            "Photos from Day 1", style = TextStyle(
                fontSize = 28.sp, color = primaryTextColor, fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            "09/22/23",
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.padding(top = 4.dp)
        )
        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
            thickness = 1.dp,
            color = borderColor
        )
        val photoList = listOf(
            R.drawable.thames,
            R.drawable.resturant,
            R.drawable.resturant2,
            R.drawable.eggs
        )
        LazyVerticalGrid(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.Start,
            columns = GridCells.Adaptive(64.dp)
        ) {
            items(count = photoList.size, itemContent = {
                Image(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
                    painter = painterResource(id = photoList[it]),
                    contentDescription = null
                )
            })
        }
        Spacer(modifier = Modifier.weight(0.7f))
        Button(
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 24.dp),
            onClick = {
                navController.navigate("generate")
            },
        ) {
            Text("Generate")
        }
/*
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(width = 1.dp, color = borderColor)
        ) {

            Box(modifier = Modifier.padding(16.dp)) {
                Column {

                    Text(
                        "What would you like to highlight from today?",
                        style = TextStyle(fontSize = 18.sp, color = Color.Black),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    LazyRow(
                        modifier = Modifier.padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(count = categoryChips.size, itemContent = {
                            val chipInfo = categoryChips[it]
                            FilterChip(
                                onClick = {
                                    categoryChips[it] = chipInfo.copy(selected = !chipInfo.selected)
                                },
                                label = {
                                    Text(chipInfo.label)
                                },
                                selected = chipInfo.selected,
                            )
                        })
                    }
                    Button(
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 24.dp),
                        onClick = {
                            navController.navigate("generate")
                        },
                    ) {
                        Text("Generate")
                    }
                }
            }
        }

 */
    }
}