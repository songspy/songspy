import org.springframework.boot.gradle.tasks.bundling.BootJar

val mockkVersion: String by project
val kotestVersion: String by project

dependencies {
    implementation(project(":commons:api"))
    implementation(project(":commons:enums"))
    implementation(project(":commons:exceptions"))
    implementation(project(":clients:spotify"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}
