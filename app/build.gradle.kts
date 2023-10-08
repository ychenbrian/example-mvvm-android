import java.util.Properties

plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}

android {
    namespace = "com.deerangle.example.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.deerangle.example.mvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures.dataBinding = true

    val secretProperties = Properties()
    file("secret.properties").inputStream().use {
        secretProperties.load(it)
    }
    val apiKey = secretProperties.getProperty("apiKey")

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.nytimes.com/svc/books/v3/\"")
            buildConfigField("String", "NYT_API_KEY", "\"$apiKey\"")
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            buildConfigField("String", "BASE_URL", "\"https://api.nytimes.com/svc/books/v3/\"")
            buildConfigField("String", "NYT_API_KEY", "\"$apiKey\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Core
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.fragment:fragment:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    // Tools
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Dagger
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.48")
    testImplementation("com.google.dagger:hilt-android-testing:2.48")
    kaptTest("com.google.dagger:hilt-compiler:2.48")

    // Okhttp
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.11.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Epoxy
    implementation("com.airbnb.android:epoxy:4.6.4")
    implementation("com.airbnb.android:epoxy-databinding:4.6.4")
    kapt("com.airbnb.android:epoxy-processor:4.6.4")
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}
