plugins {
    id("java-library")
}

group = "org.example.rest"
version = "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    api(project(":rest-domain"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

