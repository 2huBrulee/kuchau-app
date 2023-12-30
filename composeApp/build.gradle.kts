import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.mokoResources)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach { iosTarget ->
//        iosTarget.binaries.framework {
//            baseName = "ComposeApp"
//            isStatic = true
//        }
//    }
    
    sourceSets {
        // Should not be necessary in future version of either moko resources or kotlin hierarchy template
        androidMain.get().dependsOn(commonMain.get())

//        iosMain.get().dependsOn(nativeMain.get())
//        nativeMain.get().dependsOn(commonMain.get())
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.google.maps.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.bottomSheetNavigator)

            implementation(libs.koin.core)

            implementation(libs.moko.mvvm.core)
            implementation(libs.moko.mvvm.compose)

            api(libs.moko.resources)
            api(libs.moko.resources.compose)
        }
    }

    logger.lifecycle("Source Sets")

    sourceSets.forEach {
        val size = it.dependsOn.size
        logger.lifecycle("source set $it, size: $size")
        it.dependsOn.forEach { ssdo ->
            logger.lifecycle("source set $it => dependsOn $ssdo")
        }
    }

    multiplatformResources {
        multiplatformResourcesPackage = "org.simios.kuchau_app.resources" // required
        multiplatformResourcesClassName = "AppResources" // optional, default MR
        iosBaseLocalizationRegion = "en" // optional, default "en"
    }
}

android {
    namespace = "org.simios.kuchau_app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.simios.kuchau_app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

