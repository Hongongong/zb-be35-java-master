plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.23.1") // AssertJ 의존성 추가
    testImplementation("net.datafaker:datafaker:2.4.2") // DataFaker 의존성 추가
}


tasks.test {
    useJUnitPlatform()
}