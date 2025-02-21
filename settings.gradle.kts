rootProject.name = "eshop"

pluginManagement {
    val springBootVersion = extra["springBootVersion"] as String
    val dependencyManagementVersion = extra["dependencyManagementVersion"] as String
    val sonarqubeVersion = extra["sonarqubeVersion"] as String

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version dependencyManagementVersion
        id("org.sonarqube") version sonarqubeVersion
    }
}

