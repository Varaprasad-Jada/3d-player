// Top-level build file where you can add configuration options common to all sub-projects/modules in the project.

plugins {
    id("com.android.application") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    compileSdk = 33
}

task<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

task<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileTestKotlin") {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}