import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion: String = "1.4.31"
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
}

group = "club.geek66.example.framework"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	/*implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-actuator")*/
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.flowable:flowable-spring-boot-starter:6.6.0")
	implementation("org.flowable:flowable-spring-boot-starter-rest:6.6.0")
	implementation("org.flowable:flowable-spring-boot-starter-actuator:6.6.0")
	// implementation("de.codecentric:spring-boot-admin:")
	implementation("org.flowable:flowable-engine:6.6.0")

	implementation("com.h2database:h2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "${project.properties["javaVersion"]}"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}