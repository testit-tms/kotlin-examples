import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "2.0.20"
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "org.example"

val slf4jVersion = "1.7.2"
val kotest = "5.8.1"

dependencies {
    testImplementation("ru.testit:testit-api-client-kotlin:0.3.0")
    testImplementation("ru.testit:testit-kotlin-commons:0.3.0")
    testImplementation("ru.testit:testit-adapter-kotest:0.3.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    testImplementation("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4jVersion")
    testImplementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    testImplementation("com.squareup.moshi:moshi-adapters:1.15.1")
    testImplementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation("io.kotest:kotest-runner-junit5:$kotest")
    testImplementation("io.kotest:kotest-framework-datatest:5.9.1")
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
tasks.test {
   useJUnitPlatform()
}


kotlin {
    jvmToolchain(11)
}