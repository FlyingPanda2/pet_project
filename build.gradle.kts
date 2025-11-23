plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Selenide
    testImplementation("com.codeborne:selenide:7.12.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:6.3.0")

    // Rest Assured
    testImplementation("io.rest-assured:rest-assured:5.5.0")

    //Allure report
    testImplementation("org.aspectj:aspectjweaver:1.9.22")
    testImplementation("io.qameta.allure:allure-selenide:2.30.0")
    testImplementation("io.qameta.allure:allure-commandline:2.30.0")
    testImplementation("io.qameta.allure:allure-assertj:2.30.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.30.0")
    testImplementation("io.qameta.allure:allure-java-commons:2.30.0")


}

tasks.test {
    useJUnitPlatform()
}