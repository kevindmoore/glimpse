package com.journeyai.glimpse.ui.screens

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.api.gax.rpc.ApiException
import com.google.auth.oauth2.UserCredentials
import com.google.photos.library.v1.PhotosLibraryClient
import com.google.photos.library.v1.PhotosLibrarySettings
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.R
import com.journeyai.glimpse.ui.SigninInfo
import com.journeyai.glimpse.ui.theme.borderColor
import com.journeyai.glimpse.ui.theme.primaryTextColor
import com.journeyai.glimpse.ui.theme.secondaryText


@Composable
fun GrantAccess() {
    val googleSigninlauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {

            }
        }
    val navController = LocalNavigatorProvider.current
    val activity = LocalContext.current as Activity
    val googleSignIn = remember {
        SigninInfo(activity)
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            "Photos from Day 1",
            style = TextStyle(
                fontSize = 28.sp,
                color = primaryTextColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Text(
            "09/22/23",
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier
                .padding(top = 4.dp)
        )
        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
            thickness = 1.dp,
            color = borderColor
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 40.dp)
                            .width(90.dp)
                            .height(90.dp),
                        painter = painterResource(id = R.drawable.pana),
                        contentDescription = null
                    )
                }
            }
            item {

                Text(
                    "Go full-access for the full magic!",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = primaryTextColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(top = 40.dp)
                )
            }
            item {
                Text(
                    "Our app will sync images for each day to help you easily organize your travel moments.",
                    style = TextStyle(fontSize = 14.sp, color = secondaryText),
                    modifier = Modifier
                        .padding(top = 40.dp)
                )
            }
            item {

                Button(
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 24.dp),
                    onClick = {
                        navController.navigate("photos")
//        if (googleSignIn.currentAccount == null) {
//          googleSigninlauncher.launch(googleSignIn.googleSignInClient.signInIntent)
//        } else authPhotos(googleSignIn)
                    },
                ) {
                    Text("Grant Photo Access")
                }
            }
        }
    }
}

fun authPhotos(signinInfo: SigninInfo) {
    // Set up the Photos Library Client that interacts with the API
    val settings = PhotosLibrarySettings.newBuilder()
        .setCredentialsProvider(
            FixedCredentialsProvider.create(
                UserCredentials.newBuilder()
                    .setClientId("36917969289-89rqeju2bj210cn4gc63gdk58t8bg3ab.apps.googleusercontent.com")
                    .setClientSecret("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")
                    .build()
            )
        )
        .build()

    try {
        PhotosLibraryClient.initialize(settings).use { photosLibraryClient ->

            val albums = photosLibraryClient.listAlbums()
            if (albums != null) {

            }
        }
    } catch (e: ApiException) {
        Log.e("Photos", "Problems accessing albums", e)
    }
}