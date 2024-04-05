plugins {
    id("com.android.application")
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Core library
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.4.0") // Updated to latest stable version

    // Additional Android KTX libraries
    implementation("androidx.activity:activity:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0-alpha03") // Updated to latest stable version
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0-alpha03") // Updated to latest stable version

    // Networking library
    implementation("com.android.volley:volley:1.2.1")

    // JSON parsing library
    implementation("com.google.code.gson:gson:2.8.8")

    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.10.0")
    implementation ("com.squareup.picasso:picasso:2.8")

    // Room persistence library
    implementation("androidx.room:room-runtime:2.4.2")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.6.0-alpha03") // Updated to latest stable version
    annotationProcessor("androidx.room:room-compiler:2.4.2")

    implementation ("com.android.volley:volley:1.2.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21") {
        because("Force Kotlin standard library version to resolve conflicts")
    }
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.21") {
        because("Force Kotlin JDK 8 standard library version to resolve conflicts")
    }

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
    }
}
