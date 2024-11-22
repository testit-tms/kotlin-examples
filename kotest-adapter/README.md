# Kotest example
Example of tests with Kotest framework and adapter for Test IT of a Gradle project

## Setup

1. Install [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
2. Install [Gradle](https://gradle.org/install/)
3. Clone this repository `git clone https://github.com/testit-tms/kotlin-examples.git && cd kotest-adapter`
4. Configure the tests to run in **testit.properties** file. [How to configure?](https://github.com/testit-tms/adapters-kotlin/tree/main/testit-adapter-kotest#configuration)
5. Run tests via `gradle test` (or `./gradlew test`) to upload the results to TMS

## Project structure

* **src/test/kotlin/** – test files
    * **NestingTest.kt** – parametrized test examples in a fun-style
    * **StepContextTest.kt** – simple test with steps example in a fun-style, `testCase.asStepContainer()` is required
    * **StepDescribeTests.kt** – simple tests with steps example in a describe-style, `testCase.asStepContainer()` is required
* **src/test/resources/** – resource files for tests
    * **testit.properties** - configuration file where specified base options for tests
* **build.gradle** - [build file](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html) of a Gradle project


## Metadata of autotest

Actual metadata and examples described at Kotest-adapter Readme file:
[Readme.md](https://github.com/testit-tms/adapters-kotlin/blob/main/README.md)