package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.journeyai.glimpse.models.JournalEntryResponse
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.buttonBackgroundColor
import com.journeyai.glimpse.ui.theme.primaryTextColor
import com.journeyai.glimpse.ui.theme.secondaryText

@Composable
fun Journal() {
    val navController = LocalNavigatorProvider.current
    val currentData = LocalDataProvider.current
    val journalEntryResponse: JournalEntryResponse =
        rememberSaveable { currentData.currentJournalEntryResponse ?: JournalEntryResponse() }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Box(modifier = Modifier.weight(0.9f)) {
            LazyColumn {
                item {
                    journalEntryResponse?.data?.forEach { entry ->
                        val title = entry.title.filterNot { it == '*' }
                        Row {
                            Text(
                                title,
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    color = primaryTextColor,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                            Spacer(modifier = Modifier.weight(0.8f))
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(end = 16.dp)
                                    .width(18.dp)
                                    .height(18.dp),
                                painter = painterResource(id = R.drawable.open_eye),
                                contentDescription = null
                            )

                        }
                        Divider(
                            modifier = Modifier.padding(top = 24.dp),
                            thickness = 1.dp,
                            color = borderColor
                        )
                        val entryText = entry.entry.filterNot { it == '*' }
                        Text(
                            entryText,
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = secondaryText,
                            ),
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier
            .weight(0.1f)
            .align(Alignment.End)) {
            Button(
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackgroundColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp),
                onClick = {
                    navController.navigate("main") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
            ) {
                Text("Done")
            }
        }
    }
}