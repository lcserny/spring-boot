node("!master") {
    stage("GIT checkout") {
        git 'https://github.com/lcserny/spring-boot'
    }

    stage("Maven package") {
        def mvnHome = tool name: 'maven-3.3.9', type: 'maven'
        def mvnCmd = "${mvnHome}/bin/mvn"
        sh label: "", script: "${mvnCmd} clean package"
    }

    stage("Docker build") {
        sh label: "", script: "docker build -t spring-boot-poc:1.0.0 ."
    }
}