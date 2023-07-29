val mockkVersion: String by project
val kotestVersion: String by project

dependencies {
    implementation(project(":clients:google"))
    implementation(project(":storage:db-core"))
    implementation(project(":songspy-batch"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}
