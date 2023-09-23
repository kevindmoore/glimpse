package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.LocalPrefsProvider
import com.journeyai.glimpse.Prefs
import com.journeyai.glimpse.R
import com.journeyai.glimpse.models.CATEGORY_KEY
import com.journeyai.glimpse.models.ChipInfo
import com.journeyai.glimpse.models.Festivals
import com.journeyai.glimpse.models.Food
import com.journeyai.glimpse.models.Landmarks
import com.journeyai.glimpse.models.Other
import com.journeyai.glimpse.models.People
import com.journeyai.glimpse.models.Sunsets
import com.journeyai.glimpse.ui.theme.orangeProgress
import com.journeyai.glimpse.ui.theme.primaryTextColor

@Composable
fun Categories() {
    val navController = LocalNavigatorProvider.current
    val prefs = LocalPrefsProvider.current
    val topCategories = rememberSaveable(
        saver = listSaver(
            save = {
                if (it.isNotEmpty()) {
                    it.toList()
                } else {
                    listOf()
                }
            },
            restore = {
                it.toMutableStateList()
            })
    ) {
        mutableStateListOf(ChipInfo(Landmarks), ChipInfo(Food), ChipInfo(People))
    }
    val otherCategories = rememberSaveable(
        saver = listSaver(
            save = {
                if (it.isNotEmpty()) {
                    it.toList()
                } else {
                    listOf()
                }
            },
            restore = {
                it.toMutableStateList()
            })
    ) {
        mutableStateListOf(ChipInfo(Festivals), ChipInfo(Sunsets), ChipInfo(Other))
    }
    LaunchedEffect(Unit) {
        readCategories(prefs = prefs, topCategories, otherCategories)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(48.dp)
                        .height(48.dp)
                        .clickable {
                            navController.popBackStack()

                        },
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = null
                )
            }
            Text(
                "Back",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = primaryTextColor,
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            item {
                Text(
                    "What would you like to highlight?",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = primaryTextColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
            }
            item {
                Row {
                    OutlinedButton(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = orangeProgress
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = orangeProgress,
                        ),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(top = 24.dp),
                        onClick = {
                            for (i in 0 until topCategories.size) {
                                topCategories[i] = topCategories[i].copy(selected = true)
                            }
                            for (i in 0 until otherCategories.size) {
                                otherCategories[i] = otherCategories[i].copy(selected = true)
                            }
                            saveCategories(prefs, topCategories, otherCategories)
                        },
                    ) {
                        Text(
                            "Select All",
                            style = TextStyle(
                                fontSize = 14.sp,
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 16.dp))
                    OutlinedButton(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = orangeProgress
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = orangeProgress,
                        ),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(top = 24.dp),
                        onClick = {
                            for (i in 0 until topCategories.size) {
                                topCategories[i] = topCategories[i].copy(selected = true)
                            }
                            saveCategories(prefs, topCategories, otherCategories)
                        },
                    ) {
                        Text(
                            "Select Top",
                            style = TextStyle(
                                fontSize = 14.sp,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 16.dp))
                    OutlinedButton(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = orangeProgress
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = orangeProgress,
                        ),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(top = 24.dp),
                        onClick = {
                            for (i in 0 until topCategories.size) {
                                topCategories[i] = topCategories[i].copy(selected = false)
                            }
                            for (i in 0 until otherCategories.size) {
                                otherCategories[i] = otherCategories[i].copy(selected = false)
                            }
                            saveCategories(prefs, topCategories, otherCategories)
                        },
                    ) {
                        Text(
                            "Clear All",
                            style = TextStyle(
                                fontSize = 14.sp,
                            )
                        )
                    }
                }
            }
            item {

                Text(
                    "Top Categories",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = primaryTextColor,
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
            }
            item {

                Column(modifier = Modifier.padding(top = 20.dp)) {
                    topCategories.forEachIndexed { index, info ->
                        Row {
                            Checkbox(checked = info.selected, onCheckedChange = {
                                topCategories[index] = info.copy(selected = !info.selected)
                                saveCategories(prefs, topCategories, otherCategories)
                            })
                            Text(
                                info.label,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = primaryTextColor,
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
            item {

                Text(
                    "Other Categories",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = primaryTextColor,
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
            }
            item {

                Column(modifier = Modifier.padding(top = 20.dp)) {
                    otherCategories.forEachIndexed { index, info ->
                        Row {
                            Checkbox(
                                checked = info.selected, onCheckedChange = {
                                    otherCategories[index] =
                                        info.copy(selected = !info.selected)
                                    saveCategories(prefs, topCategories, otherCategories)
                                })
                            Text(
                                info.label,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = primaryTextColor,
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
        }
    }
}

fun saveCategories(
    prefs: Prefs,
    topCategories: SnapshotStateList<ChipInfo>,
    otherCategories: SnapshotStateList<ChipInfo>
) {
    val listOfCategories = mutableListOf<String>()
    topCategories.forEach {
        if (it.selected) {
            listOfCategories.add(it.label)
        }
    }
    otherCategories.forEach {
        if (it.selected) {
            listOfCategories.add(it.label)
        }
    }
    val categoryString = listOfCategories.joinToString(",")
    prefs.saveString(CATEGORY_KEY, categoryString)
}

fun readCategories(
    prefs: Prefs,
    topCategories: SnapshotStateList<ChipInfo>,
    otherCategories: SnapshotStateList<ChipInfo>
) {
    if (prefs.hasKey(CATEGORY_KEY)) {
        val categoryString = prefs.getString(CATEGORY_KEY)
        val listOfCategories = categoryString?.split(",")
        listOfCategories?.forEach { category ->
            for (i in 0 until topCategories.size) {
                if (topCategories[i].label == category) {
                    topCategories[i] = topCategories[i].copy(selected = true)
                }
            }
            for (i in 0 until otherCategories.size) {
                if (otherCategories[i].label == category) {
                    otherCategories[i] = otherCategories[i].copy(selected = true)
                }
            }
        }
    }
}