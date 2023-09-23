package com.journeyai.glimpse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.journeyai.glimpse.models.CurrentData
import com.journeyai.glimpse.ui.screens.Categories
import com.journeyai.glimpse.ui.screens.Destination
import com.journeyai.glimpse.ui.screens.Generate
import com.journeyai.glimpse.ui.screens.MainScreen
import com.journeyai.glimpse.ui.screens.GrantAccess
import com.journeyai.glimpse.ui.screens.Journal
import com.journeyai.glimpse.ui.screens.Photos
import com.journeyai.glimpse.ui.theme.GlimpseTheme

val LocalNavigatorProvider =
  compositionLocalOf<NavHostController> { error("No navigation provided") }

val LocalDataProvider =
  compositionLocalOf { CurrentData() }

val LocalPrefsProvider =
  compositionLocalOf<Prefs> { error("No prefs provided") }

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GlimpseTheme {
        val navController = rememberNavController()
        val currentData = CurrentData()
        val context = LocalContext.current
        val prefs = remember { Prefs(context) }

        CompositionLocalProvider(
          LocalNavigatorProvider provides navController,
          LocalPrefsProvider provides prefs,
          LocalDataProvider provides currentData,
        ) {
          NavHost(navController = navController, startDestination = "main") {
            composable("main") { MainScreen() }
            composable("destination") { Destination() }
            composable("grantAccess") { GrantAccess() }
            composable("photos") { Photos() }
            composable("generate") { Generate() }
            composable("journal") { Journal() }
            composable("categories") { Categories() }
          }
        }
      }
    }
  }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  GlimpseTheme {
  }
}