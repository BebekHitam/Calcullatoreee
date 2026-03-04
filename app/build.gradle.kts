plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)



}

android {
    namespace = "com.example.kotlinonebutton"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.kotlinonebutton"
        minSdk = 28
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        compose = true
    }
    composeOptions{
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.hilt.android)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    dependencies {
        implementation(libs.lifecycle.viewmodel.compose)
    }
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.activity.compose) // Ini yang penting untuk ComponentActivity
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(libs.leakcanary.android)
    testImplementation(kotlin("test"))
}
tasks.withType<Test> {
    useJUnitPlatform()
}