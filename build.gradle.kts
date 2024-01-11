plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.20"
}

group = "com.iambulance"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.opencsv:opencsv:3.7")
	implementation ("io.springfox:springfox-swagger2:3.0.0")
	implementation ("io.springfox:springfox-swagger-ui:3.0.0")
	implementation ("io.springfox:springfox-boot-starter:3.0.0")
	implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation ("org.projectlombok:lombok")
	implementation ("commons-io:commons-io:2.15.1")
	implementation ("javax.servlet:javax.servlet-api:4.0.1")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-web")

}

tasks.withType<Test> {
	useJUnitPlatform()
}