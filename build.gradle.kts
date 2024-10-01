// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

/*
// Configure repositories globally
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

 */


// Define common settings if needed
subprojects {
    // You can define common configurations or tasks for all subprojects here
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
