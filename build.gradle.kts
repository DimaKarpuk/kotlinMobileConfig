plugins {
    kotlin("jvm") version "2.1.10"
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.codeborne:selenide:7.7.2")
    testImplementation("io.qameta.allure:allure-selenide:2.28.1")
    testImplementation("io.appium:java-client:9.2.3")
    testImplementation("org.aeonbits.owner:owner-java8:1.0.11")
    testImplementation("com.github.romankh3:image-comparison:4.4.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.16")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}