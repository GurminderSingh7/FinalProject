plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "algonquin.cst2335.finalproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "algonquin.cst2335.finalproject"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation ("com.android.volley:volley:1.2.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Room components
    implementation ("androidx.room:room-runtime:2.4.2")
    annotationProcessor ("androidx.room:room-compiler:2.4.2")
    // For Kotlin use kapt instead of annotationProcessor
    // kapt "androidx.room:room-compiler:2.4.2"


}