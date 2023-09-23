package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.journeyai.glimpse.LocalDataProvider
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.LocalPrefsProvider
import com.journeyai.glimpse.R
import com.journeyai.glimpse.models.CATEGORY_KEY
import com.journeyai.glimpse.models.ImageCategoryRequest
import com.journeyai.glimpse.models.JournalEntryRequest
import com.journeyai.glimpse.network.RetrofitInstance
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.orangeProgress
import com.journeyai.glimpse.ui.theme.primaryTextColor

@Composable
fun Generate() {
    val navController = LocalNavigatorProvider.current
    val prefs = LocalPrefsProvider.current
    val currentData = LocalDataProvider.current
    val showProgress = remember { mutableStateOf(true) }
    val enableDoneButton = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        val categoryString = prefs.getString(CATEGORY_KEY) ?: ""
        val tags = categoryString.split(",")
        val response =
            RetrofitInstance.journalEntry(JournalEntryRequest("1", "2022-09-19", "2022-09-19", tags))
//            RetrofitInstance.journalEntry(JournalEntryRequest("1", "2023-09-15", "2023-09-20", listOf("Water", "Grandiose")))
        if (response.data.isNotEmpty()) {
            currentData.currentJournalEntryResponse = response
        }
        showProgress.value = false
        enableDoneButton.value = true
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            "Day 1 Highlights",
            style = TextStyle(
                fontSize = 28.sp,
                color = primaryTextColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
            thickness = 1.dp,
            color = borderColor
        )
        Spacer(modifier = Modifier.weight(0.4f))
        if (showProgress.value) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .height(50.dp),
                    color = orangeProgress,

                    )
            }
        }
        Text(
            "Journal Generation In-progress",
            style = TextStyle(fontSize = 18.sp, color = primaryTextColor),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.weight(0.8f))
        Button(
            enabled = enableDoneButton.value,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 24.dp),
            onClick = {
                navController.navigate("journal")
            },
        ) {
            Text("Done")
        }

    }
}