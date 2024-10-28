import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "2.0.20"
}

repositories {
    mavenCentral()
}

group = "org.example"

val slf4jVersion = "1.7.2"
var kotest = "5.8.1"

dependencies {
    testImplementation(files("../vendor/testit-api-kotlin-client-1.0.0.jar"))
    testImplementation(files("../vendor/testit-kotlin-commons-1.0.0.jar"))
    testImplementation(files("../vendor/kotest-listener-1.0.0.jar"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    testImplementation("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4jVersion")
    testImplementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    testImplementation("com.squareup.moshi:moshi-adapters:1.15.1")
    testImplementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation("io.kotest:kotest-runner-junit5:$kotest")
    testImplementation(kotlin("test"))
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    testLogging {
        events = setOf(TestLogEvent.FAILED, TestLogEvent.SKIPPED, TestLogEvent.PASSED)
        showCauses = true
        showStackTraces = true
        showStandardStreams = true
    }
    systemProperties(systemProperties)
    environment(environment)
}
//tasks.test {
//    useJUnitPlatform()
//
//}


kotlin {
    jvmToolchain(11)
}