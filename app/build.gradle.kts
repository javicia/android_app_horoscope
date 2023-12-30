plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.horoscopoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.horoscopoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.horoscopoapp.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "javiname", "[DEBUG] HoroscopeApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "javiname", "HoroscopeApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

}

dependencies {

    val navVersion = "2.7.1"
    val cameraVersion = "1.2.3"
    val material ="1.11.0"
    val DaggerHilt = "2.48"
    val espresso = "3.5.1"


    implementation("androidx.test:runner:1.5.2")

    //NavComponent
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //DaggerHilt
    implementation("com.google.dagger:hilt-android:${DaggerHilt}")
    kapt("com.google.dagger:hilt-compiler:${DaggerHilt}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")

    //Camera X
    //noinspection GradleDependency
    implementation("androidx.camera:camera-core:${cameraVersion}")
    //noinspection GradleDependency
    implementation("androidx.camera:camera-camera2:${cameraVersion}")
    //noinspection GradleDependency
    implementation("androidx.camera:camera-lifecycle:${cameraVersion}")
    //noinspection GradleDependency
    implementation("androidx.camera:camera-view:${cameraVersion}")
    //noinspection GradleDependency
    implementation("androidx.camera:camera-extensions:${cameraVersion}")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:${material}")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:${material}")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //UnitTesting
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("io.mockk:mockk:1.12.3")

    //UITesting
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:${espresso}")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:${espresso}")
    androidTestImplementation("androidx.test.espresso:espresso-intents:${espresso}")
    androidTestImplementation("com.google.dagger:hilt-android-testing:${DaggerHilt}")
    androidTestImplementation("androidx.fragment:fragment-testing:1.6.2")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:${DaggerHilt}")
}