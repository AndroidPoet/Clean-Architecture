buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(BuildPlugins.TOOLS_BUILD_GRADLE)
        classpath(BuildPlugins.SAFE_ARGS_GRADLE_PLUGIN)
        classpath(BuildPlugins.DAGGER_HILT_PLUGIN)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath(kotlin("serialization", version = Lib.Kotlin.KOTLIN_VERSION))
        classpath(BuildPlugins.KTLINT_GRADLE_PLUGIN)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean")
    .configure {
        delete(rootProject.buildDir)
    }

