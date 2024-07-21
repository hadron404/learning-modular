plugins {
    id("java")
}

group = "org.example.rest"
version = "1.0.0-SNAPSHOT"

//java {
//    sourceCompatibility = JavaVersion.VERSION_21
//}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
