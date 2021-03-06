import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}


version = "1.0.0"

kotlin.sourceSets {
    getByName("main").kotlin.srcDir("src")
    getByName("main").resources.srcDir("resources")
    getByName("test").kotlin.srcDir("test")
    getByName("test").resources.srcDir("test/resources")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    compile("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-smile:2.9.8")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}