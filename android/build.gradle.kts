plugins {
    id("org.jetbrains.compose") version "1.4.0"
    id("com.android.application")
    kotlin("android")
    id ("kotlin-parcelize")
}

group = "com.davidmatillacode"
version = "1.0"

repositories {
    jcenter()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation ("com.arkivanov.decompose:decompose:1.0.0")
    implementation ("com.arkivanov.decompose:extensions-compose-jetpack:1.0.0")
    implementation("io.github.xxfast:decompose-router:0.3.0")
    implementation ("com.arkivanov.decompose:extensions-compose-jetbrains:1.0.0")

}

android {
    compileSdkVersion(34)
    defaultConfig {
        applicationId = "com.davidmatillacode.android"
        minSdkVersion(24)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    namespace = "com.davidmatillacode.android"
}