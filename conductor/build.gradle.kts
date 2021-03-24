import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("application")
	kotlin("jvm") version "1.4.30"
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${properties["kotlinVersion"]}")
	implementation("org.jetbrains.kotlin:kotlin-reflect:${properties["kotlinVersion"]}")
}

application {
	mainClass.set("club.geek66.example.framework.nflow.ApplicationKt")
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