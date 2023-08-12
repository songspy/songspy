import org.springframework.boot.gradle.tasks.bundling.BootJar

val mockkVersion: String by project
val kotestVersion: String by project
val jwtVersion: String by project

dependencies {
    implementation(project(":commons:api"))

    implementation(project(":clients:google"))
    implementation(project(":clients:spotify"))

    implementation(project(":storage:db-core"))

    implementation(project(":songspy-batch"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("io.jsonwebtoken:jjwt-api:$jwtVersion")
    implementation("io.jsonwebtoken:jjwt-impl:$jwtVersion")
    implementation("io.jsonwebtoken:jjwt-jackson:$jwtVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}
