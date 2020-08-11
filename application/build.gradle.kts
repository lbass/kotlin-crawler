tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jsoup:jsoup:1.13.1")
}