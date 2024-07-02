// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.compose.compiler) apply false
   // kotlin(libs.plugins.jvm.get().pluginId).version(libs.versions.kotlin).apply(false)
    kotlin("plugin.serialization") version libs.versions.kotlin apply false
   // alias(libs.plugins.kotlin.parcelize) apply false

}