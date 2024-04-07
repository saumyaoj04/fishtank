plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.devshiv.fishtankecell"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devshiv.fishtankecell"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "Fish Tank E-Cell")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-firestore:24.11.0")
    implementation("com.google.firebase:firebase-analytics:21.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    api("tk.zielony:carbon:0.16.0.1")

    implementation("com.daimajia.easing:library:2.0@aar")
    implementation("com.daimajia.androidanimations:library:2.4@aar")

    implementation("com.github.bumptech.glide:glide:4.16.0")

    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("com.github.gabriel-TheCode:AestheticDialogs:1.3.6")

    implementation("com.google.android.play:core:1.10.3")

    implementation("com.tuyenmonkey:mkloader:1.4.0")

    implementation("com.github.scottyab:showhidepasswordedittext:0.8")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

}