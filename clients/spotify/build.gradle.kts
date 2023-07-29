val openFeignVersion: String by project

dependencies {
    implementation(project(":commons:extension"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:$openFeignVersion")
}
