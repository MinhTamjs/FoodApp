plugins {
    // Essential plugins for Android application
    id("com.android.application")
    id("com.google.gms.google-services") // Google services for Firebase integration
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") // Secrets plugin for Google Maps
}

android {
    namespace = "com.example.foodapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.foodapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Specifies the runner to use for tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // Set to true for production builds to enable code shrinking
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        // Java compatibility settings
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true // Enables view binding
    }
}

dependencies {
    // Support libraries
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Utility library for JSON
    implementation("com.google.code.gson:gson:2.10.1")

    // Firebase dependencies managed by BOM
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-storage")

    // Image loading library
    implementation("com.github.bumptech.glide:glide:4.12.0")

    // Zalo pay
    implementation(fileTree(mapOf("dir" to "E:\\Mobile Projects\\ZalopayTest", "include" to listOf("*.aar", "*.jar"))))

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Networking library
    implementation("com.squareup.okhttp3:okhttp:4.6.0")
    implementation("commons-codec:commons-codec:1.14")

    // Google Maps
    implementation("com.google.android.gms:play-services-maps:18.2.0")
}
