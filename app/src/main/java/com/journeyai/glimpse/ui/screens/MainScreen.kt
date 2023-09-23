package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.R
import com.journeyai.glimpse.ui.widgets.BottomItem
import com.journeyai.glimpse.ui.widgets.CreateScaffold
import com.journeyai.glimpse.ui.widgets.IconInfo

@Composable
fun MainScreen() {
    val navController = LocalNavigatorProvider.current
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }
    CreateScaffold(
        bottomBarList = listOf(
            BottomItem(selected = selectedIndex.intValue == 0, icon = IconInfo(
                icon = ImageVector.vectorResource(
                    R.drawable.profile
                ), contextText = "Profile"
            ), onclick = {
                selectedIndex.intValue = 0
            }),
            BottomItem(selected = selectedIndex.intValue == 1, icon = IconInfo(
                icon = ImageVector.vectorResource(
                    R.drawable.add_journal
                ), contextText = "Add Journal"
            ), onclick = {
                navController.navigate("destination")
            }),
            BottomItem(selected = selectedIndex.intValue == 1, icon = IconInfo(
                icon = ImageVector.vectorResource(
                    R.drawable.hub_people
                ), contextText = "Hub"
            ), onclick = {
                selectedIndex.intValue = 1
            }),
        ), content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (selectedIndex.intValue) {
                    0 -> Profile()
                    1 -> Hub()
                }
            }
        }
    )
}