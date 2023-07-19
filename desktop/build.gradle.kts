import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.4.0"
}

group = "com.davidmatillacode"
version = "1.0"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
                implementation ("com.arkivanov.decompose:decompose:1.0.0")
                implementation ("com.arkivanov.decompose:extensions-compose-jetbrains:1.0.0")
                implementation("io.github.xxfast:decompose-router:0.3.0")
                implementation ("org.kodein.di:kodein-di:7.19.0")
                //implementation ("org.kodein.di:kodein-di-generic-jvm:7.20.2")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}