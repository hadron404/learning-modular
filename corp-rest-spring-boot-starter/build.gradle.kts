plugins {
    id("java-library")
    id("org.springframework.boot") version ("3.3.2")
    id("io.spring.dependency-management") version ("1.1.6")
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
extra["springCloudVersion"] = "2023.0.3"

dependencies {
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    api(project(":rest-domain"))
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
