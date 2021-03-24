import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("application")
	kotlin("jvm") version "1.4.30"
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("plugin.spring") version "1.4.30"
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("io.nflow:nflow-engine:7.2.4")
	implementation("com.h2database:h2")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("io.nflow:nflow-rest-api-spring-web:7.2.4")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation(group = "io.nflow", name = "nflow-explorer", version = "7.2.4", ext = "tar.gz")
}

application {
	mainClass.set("club.geek66.example.framework.nflow.ApplicationKt")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks {
	fun KotlinCompile.kotlinOptions() {
		kotlinOptions { jvmTarget = "${project.properties["javaVersion"]}" }
	}
	compileKotlin {
		kotlinOptions()
	}
	compileTestKotlin {
		kotlinOptions()
	}
}