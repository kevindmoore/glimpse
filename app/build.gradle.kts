plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")
  id("kotlin-parcelize")
}

android {
  namespace = "com.journeyai.glimpse"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.journeyai.glimpse"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
    freeCompilerArgs = freeCompilerArgs + listOf(
      "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
      "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
      "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
      "-opt-in=androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi",
      "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
    )
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packaging {
    resources {
      pickFirsts += "META-INF/INDEX.LIST"
      pickFirsts += "META-INF/DEPENDENCIES"
//      excludes += "/META-INF/{AL2.0,LGPL2.1}"
//      excludes += "/META-INF/*"
    }
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

  implementation(platform("androidx.compose:compose-bom:2023.09.00"))
  implementation("androidx.compose.foundation:foundation")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.material3:material3")
  implementation("androidx.navigation:navigation-compose:2.7.3")
  implementation("com.airbnb.android:lottie-compose:6.1.0")
  implementation("com.google.photos.library:google-photos-library-client:1.7.3")
  implementation("com.google.android.gms:play-services-auth:20.7.0")
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.moshi:moshi:1.15.0")
  implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
  implementation("androidx.datastore:datastore-preferences:1.0.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
  ksp ("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")


  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
}