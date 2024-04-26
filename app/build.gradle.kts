import kotlinx.kover.gradle.plugin.dsl.KoverReportExtension

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.story_tail.adventures.android"
    compileSdk = 34

    configureTestOptions(project)

    defaultConfig {
        applicationId = "com.story_tail.adventures.android"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

fun configureTestOptions(project: Project){
    // Kotlin Kover
    project.plugins.apply("org.jetbrains.kotlinx.kover")
    project.extensions.configure<KoverReportExtension> {
        project.androidComponents.onVariants {
            androidReports(it.name) {
                xml {
                    // HACK: update the report file so that codecov picks it up automatically
                    setReportFile(project.layout.buildDirectory.file("reports/kover/${it.name}/report.xml"))
                }
            }
        }
    }
}