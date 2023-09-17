import org.springframework.boot.gradle.tasks.bundling.BootJar

val mockkVersion: String by project
val kotestVersion: String by project

dependencies {
    implementation(project(":clients:spotify"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}
