plugins {
    id("java")
    id ("org.springframework.boot") version "3.4.4"
    id ("io.spring.dependency-management") version "1.1.7"
    id ("io.freefair.lombok") version "8.6"
    kotlin("jvm")
}

group = "com.footprints"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly ("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.2.0")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.boot:spring-boot-starter-security")
    annotationProcessor("org.projectlombok:lombok")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.mapstruct:mapstruct:1.6.0")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.0")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:1.6.0")

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}