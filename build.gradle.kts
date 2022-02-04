plugins {
    java
    id ("org.openapi.generator") version "5.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

openApiGenerate {
    generatorName.set("java")
    library.set("okhttp-gson-nextgen")
    inputSpec.set("$projectDir/src/main/resources/error.yaml")
    outputDir.set("$buildDir/generated")
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.jleth.util:okhttp3-logging:1.0.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("io.gsonfire:gson-fire:1.8.5")
    implementation(group= "org.threeten", name= "threetenbp", version= "1.5.1")
    implementation("io.swagger:swagger-annotations:1.6.4")
    implementation("com.squareup.okio:okio:3.0.0")
}

java.sourceSets["main"].java.srcDir("$buildDir/generated/src/main/java")

tasks.named("compileJava") {
    dependsOn("openApiGenerate")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}