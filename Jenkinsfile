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

//    stage("Docker push") {
//        withCredentials(some stuff here) {
//            sh label: "", script: "docker login -u blabla -p $credVar"
//            sh label: "", script: "docker push spring-boot-poc:1.0.0"
//        }
//    }

//    stage("Run container on server") {
//        def dockerRun = docker run -p 8080:8080 -d --name my-spring-boot spring-boot-poc:1.0.0
//        sshagent(install this plugin stuff) {
//            sh label: "", script: "ssh -o StrictHostKeyChecking=no someuser@192.168.1.1 ${dockerRun}"
//        }
//    }
}