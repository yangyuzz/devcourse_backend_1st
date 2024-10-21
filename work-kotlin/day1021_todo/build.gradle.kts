plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25" // kotlin클래스는 기본 final이라 스프링 빈은 상속 프록시를 쓰는데ㅠㅠ open좀 해줘.. all open
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.jpa") version "1.9.25" // kotlin data 클래스에는 기본생성자가 없음. no-arg 기본 생성자 만들어 주는 플러그인
}

group = "com.grepp"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.5")
    implementation("io.jsonwebtoken:jjwt-gson:0.12.5")

    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    // 신형 swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")


//    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
//    implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.12.5'
//    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
//    implementation group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.12.5'
//    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
//    implementation group: 'io.jsonwebtoken', name: 'jjwt-gson', version: '0.12.5'
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
