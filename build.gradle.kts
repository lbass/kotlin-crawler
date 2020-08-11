import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectGroup: String by project
val applicationVersion: String by project

plugins {
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    id("org.asciidoctor.jvm.convert") apply false
    id("org.jmailen.kotlinter") apply false
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

allprojects {
    group = projectGroup
    version = applicationVersion

    repositories {
        mavenCentral()
    }

    configurations {
        all {
            exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
            exclude(group = "org.junit.vintage")
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.asciidoctor.jvm.convert")
    apply(plugin = "org.jmailen.kotlinter")

    dependencyManagement {
        val springCloudDependenciesVersion: String by project
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudDependenciesVersion}")
        }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.springframework.boot:spring-boot-starter-log4j2")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("org.apache.commons:commons-lang3:3.11")
    }

    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform() {
            excludeTags("develop")
        }
    }

    tasks.register<Test>("unitTest") {
        group = "verification"
        useJUnitPlatform {
            excludeTags("develop", "context", "restdocs")
        }
    }

    tasks.register<Test>("contextTest") {
        group = "verification"
        useJUnitPlatform {
            includeTags("context")
        }
    }

    tasks.register<Test>("restDocsTest") {
        group = "verification"
        useJUnitPlatform {
            includeTags("restdocs")
        }
    }

    tasks.register<Test>("developTest") {
        group = "verification"
        useJUnitPlatform {
            includeTags("develop")
        }
    }

    tasks.getByName("asciidoctor") {
        dependsOn("restDocsTest")
    }

    tasks.getByName("clean") {
        delete("out")
    }
}