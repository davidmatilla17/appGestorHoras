plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.4.0"
    id("com.android.library")
    id ("kotlin-parcelize")
    id("app.cash.sqldelight") version "2.0.0-rc01"
}
sqldelight {
    databases {
        create("Database") {
            packageName.set("com.davidmatillacode.common.db")
        }
    }
}

group = "com.davidmatillacode"
version = "1.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation ("com.arkivanov.decompose:decompose:1.0.0")
                implementation("io.github.xxfast:decompose-router:0.3.0")
                implementation("app.cash.sqldelight:sqlite-driver:2.0.0-rc01")
                implementation ("org.kodein.di:kodein-di:7.20.2")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api("androidx.appcompat:appcompat:1.4.1")
                api("androidx.core:core-ktx:1.7.0")
                implementation("app.cash.sqldelight:android-driver:2.0.0-rc01")
                implementation ("org.kodein.di:kodein-di:7.20.2")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation("app.cash.sqldelight:sqlite-driver:2.0.0-rc01")
                implementation ("org.kodein.di:kodein-di:7.20.2")
                implementation ("com.github.sarxos:webcam-capture:0.3.12")
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(34)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(34)
    }
    sourceSets["main"].res.srcDirs("src/commonMain/res")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    namespace = "com.davidmatillacode.common"
}