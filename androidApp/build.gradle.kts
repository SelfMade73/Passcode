plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.dev.passcode.android"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha08"
    }
    repositories {
        google()
        mavenCentral()
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val composeVersion = "1.1.1"
    val composeActivityVersion = "1.4.0"
    val viewModelVersion = "2.4.1"
    val kotlinCoreKtx = "1.7.0"
    val kotlinCoroutinesKtx = "1.6.1"
    val navVersion = "2.4.2"
    val kodeinVersion = "5.2.0"
    val systemControllerVersion = "0.24.7-alpha"

    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    //Jetpack Compose
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.activity:activity-compose:$composeActivityVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelVersion")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion")

    //CoreKtx
    implementation("androidx.core:core-ktx:$kotlinCoreKtx")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesKtx")

    // Navigation
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Kodein
    implementation ("org.kodein.di:kodein-di-generic-jvm:$kodeinVersion")
    implementation ("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")

    // SystemController
    implementation ("com.google.accompanist:accompanist-systemuicontroller:$systemControllerVersion")


}