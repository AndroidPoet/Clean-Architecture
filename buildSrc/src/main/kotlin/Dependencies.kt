import Lib.Networking

/** This file contains versions of all the dependencies used in the module  */

object BuildPlugins {
    private const val TOOLS_BUILD = "7.0.4"
    private const val KT_LINT = "9.2.1"
    private const val SAFE_ARGS = "2.3.5"

    const val TOOLS_BUILD_GRADLE =
        "com.android.tools.build:gradle:${TOOLS_BUILD}"
    const val KTLINT_GRADLE_PLUGIN =
        "org.jlleitschuh.gradle:ktlint-gradle:${KT_LINT}"
    const val SAFE_ARGS_GRADLE_PLUGIN =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${SAFE_ARGS}"
    const val DAGGER_HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.38.1"
    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
    const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
    const val KOTLIN_PARCELABLE_PLUGIN = "kotlin-parcelize"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val DAGGER_HILT = "dagger.hilt.android.plugin"
}

object Lib {

    object Kotlin {
        const val KOTLIN_VERSION = "1.6.0"
        private const val KTX_CORE_VERSION = "1.2.0"

        const val KT_STD = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KOTLIN_VERSION}"
        const val KTX_CORE = "androidx.core:core-ktx:${KTX_CORE_VERSION}"
    }

    object Android {
        private const val MATERIAL_DESIGN_VERSION = "1.4.0"
        const val COMPOSE_VERSION = "1.2.0-alpha01"
        const val COMPOSE_COMPILER = "1.2.0-alpha01"
        const val Accompanist="2.4.0-rc01"
        private const val ACCOMPANIST_VERSION = "0.24.1-alpha"
        const val NavAnimation="0.24.13-rc"
        const val ACT_COMPOSE = "androidx.activity:activity-compose:1.4.0"


        const val FLOW_LAYOUT = "com.google.accompanist:accompanist-flowlayout:0.24.13-rc"

        const val CONSTRAINT_LAYOUT_COMPOSE =
            "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc02"

        const val COMPOSE_UI = "androidx.compose.ui:ui:${COMPOSE_VERSION}"
        const val COIL_COMPOSE = "io.coil-kt:coil-compose:1.4.0"
        const val COMPOSE_PAGING = "androidx.paging:paging-compose:1.0.0-alpha14"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${COMPOSE_VERSION}"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling-preview:${COMPOSE_VERSION}"
        const val DEBUG_TOOLING = "androidx.compose.ui:ui-tooling:${COMPOSE_VERSION}"
        const val navigationCompose = "androidx.navigation:navigation-compose:${Accompanist}"

        const val navigationAnimation ="com.google.accompanist:accompanist-navigation-animation:${NavAnimation}"
        const val ACCOMPANIST_SYSTEM_UI_CONTROLLER =
            "com.google.accompanist:accompanist-systemuicontroller:${ACCOMPANIST_VERSION}"

        const val MATERIAL_DESIGN =
            "com.google.android.material:material:${MATERIAL_DESIGN_VERSION}"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0-beta01"
        const val ACCOMPANIST_INSETS = "com.google.accompanist:accompanist-insets:0.22.0-rc"
        const val COIL_IMAGE_LOADING ="io.coil-kt:coil-compose:2.1.0"




    }

    object Di {
        private const val DAGGER_VERSION = "2.40.5"
        const val hilt = "com.google.dagger:hilt-android:${DAGGER_VERSION}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${DAGGER_VERSION}"

        const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-rc01"
    }

    object Async {
        private const val COROUTINES_VERSION = "1.6.0"

        const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${COROUTINES_VERSION}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${COROUTINES_VERSION}"
    }

    object Networking {
        private const val RETROFIT_VERSION = "2.9.0"
        const val OKHTTP_VERSION = "4.7.2"

        private const val MOSHI_VERSION = "1.13.0"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${RETROFIT_VERSION}"
        const val RETROFIT_GSON =
            "com.squareup.retrofit2:converter-gson:${RETROFIT_VERSION}"
        const val LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${OKHTTP_VERSION}"


        const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${RETROFIT_VERSION}"

        // moshi
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:${MOSHI_VERSION}"
        const val MOSHI_COMPILER = "com.squareup.moshi:moshi-kotlin-codegen:${MOSHI_VERSION}"


    }

    object Serialization {
        private const val GSON_VERSION = "2.8.6"
        const val GSON = "com.google.code.gson:gson:${GSON_VERSION}"
    }

    object Logger {
        private const val TIMBER_VERSION = "4.7.1"
        const val TIMBER = "com.jakewharton.timber:timber:${TIMBER_VERSION}"
    }


    object Paging {
        private const val PAGING_VERSION = "3.1.0"
        const val PAGING_3 = "androidx.paging:paging-runtime:${PAGING_VERSION}"
        const val PAGING_COMPOSE = "androidx.paging:paging-compose:1.0.0-alpha14"
    }

    object Room {
        private const val roomVersion = "2.4.1"
        const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val roomCompiler = "androidx.room:room-compiler:$roomVersion"

        // optional - Kotlin Extensions and Coroutines support for Room
        const val roomKtx = "androidx.room:room-ktx:$roomVersion"

        // optional - Paging 3 Integration
        const val roomPaging = "androidx.room:room-paging:2.4.1"
    }
}

object TestLib {
    private const val COROUTINES_VERSION = "1.3.7"
    private const val ANDROID_JUNIT_VERSION = "1.0.0"
    private const val ROBO_ELECTRIC_VERSION = "4.3"
    private const val ARCH_CORE_VERSION = "2.1.0"
    private const val CORE_TEST_VERSION = "1.2.0"
    private const val JUNIT_VERSION = "4.13"

    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${COROUTINES_VERSION}"
    const val ROBO_ELECTRIC = "org.robolectric:robolectric:${ROBO_ELECTRIC_VERSION}"
    const val MOCK_WEB_SERVER =
        "com.squareup.okhttp3:mockwebserver:${Networking.OKHTTP_VERSION}"
    const val CORE_TEST = "androidx.test:core-ktx:${CORE_TEST_VERSION}"
    const val JUNIT = "junit:junit:${JUNIT_VERSION}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${ANDROID_JUNIT_VERSION}"
    const val ARCH_CORE = "androidx.arch.core:core-testing:${ARCH_CORE_VERSION}"
    const val MOCKK = "io.mockk:mockk:1.10.5"
}

object DebugLib {
    private const val LEAK_CANARY_VERSION = "2.3"
    const val LEAK_CANARY =
        "com.squareup.leakcanary:leakcanary-android:${LEAK_CANARY_VERSION}"
}