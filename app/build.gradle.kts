// Manifest version information!

plugins {
    id(BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
    id("org.jlleitschuh.gradle.ktlint")
}

subprojects {
    apply {
        from("variants.gradle.kts")
    }
}

// def preDexEnabled = "true" == System.getProperty("pre-dex", "true")

android {
    compileSdk = (ProjectProperties.COMPILE_SDK)

    defaultConfig {
        applicationId = (ProjectProperties.APPLICATION_ID)
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }



    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// Required for annotation processing plugins like Dagger
kapt {
    generateStubs = true
    correctErrorTypes = true
}

dependencies {
    /* Android Designing and layout */
    implementation(Lib.Android.livedata)
    //implementation(Lib.Android.navigationCompose)

    implementation(Lib.Kotlin.KT_STD)
    implementation(Lib.Android.MATERIAL_DESIGN)
    implementation(Lib.Android.CONSTRAINT_LAYOUT_COMPOSE)
    implementation(Lib.Android.ACCOMPANIST_INSETS)
    implementation(Lib.Android.ACT_COMPOSE)
    implementation(Lib.Android.FLOW_LAYOUT)
    /* UI */
    implementation(Lib.Android.COMPOSE_MATERIAL)
    implementation(Lib.Android.COMPOSE_UI)
    implementation(Lib.Android.navigationCompose)
    implementation(Lib.Android.ACCOMPANIST_SYSTEM_UI_CONTROLLER)



    implementation(Lib.Android.appCompat)
    implementation(Lib.Kotlin.KTX_CORE)

    /*DI*/
    implementation(Lib.Di.hilt)
    implementation(Lib.Di.hiltNavigationCompose)
    implementation(Lib.Di.viewmodel)

    kapt(Lib.Di.hiltCompiler)
    kapt(Lib.Di.hiltAndroidCompiler)

    /* Logger */
    implementation(Lib.Logger.TIMBER)
    /* Async */
    implementation(Lib.Async.COROUTINES)
    implementation(Lib.Async.COROUTINES_ANDROID)


    implementation(Lib.Serialization.GSON)

    /* Networking */
    implementation(Lib.Networking.RETROFIT)
    implementation(Lib.Networking.RETROFIT_GSON)
    implementation(Lib.Networking.LOGGING)
    implementation(Lib.Networking.MOSHI_CONVERTER)
    implementation(Lib.Networking.MOSHI)
    kapt(Lib.Networking.MOSHI_COMPILER)
    implementation(Lib.Android.COIL_IMAGE_LOADING)

    /* Local Database */
    /* Paging */
    implementation(Lib.Paging.PAGING_3)
    /* Room */
    api(Lib.Room.roomRuntime)
    kapt(Lib.Room.roomCompiler)
    api(Lib.Room.roomKtx)
    api(Lib.Room.roomPaging)


    /*Testing*/
    testImplementation(TestLib.JUNIT)
    testImplementation(TestLib.CORE_TEST)
    testImplementation(TestLib.ANDROID_JUNIT)
    testImplementation(TestLib.ARCH_CORE)
    testImplementation(TestLib.MOCK_WEB_SERVER)
    testImplementation(TestLib.ROBO_ELECTRIC)
    testImplementation(TestLib.COROUTINES)
    testImplementation(TestLib.MOCKK)

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Lib.Android.COMPOSE_VERSION}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Lib.Android.COMPOSE_VERSION}")
}