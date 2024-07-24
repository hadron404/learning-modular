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
dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
