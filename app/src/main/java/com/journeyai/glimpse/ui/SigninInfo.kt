package com.journeyai.glimpse.ui

import android.app.Activity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SigninInfo(val activity: Activity) {
  // Configure sign-in to request the user's ID, email address, and basic
  // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
  val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    .requestEmail()
    .build()

  var currentAccount: GoogleSignInAccount?
  val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(activity, gso)

  init {

    // Build a GoogleSignInClient with the options specified by gso.
    currentAccount = GoogleSignIn.getLastSignedInAccount(activity)
  }

}