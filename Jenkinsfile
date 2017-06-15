#!/usr/bin/env groovy
node {

  checkout scm
  env.MAVEN_HOME = "/var/backups"
  env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
  stage('Package') {
    dir('deployment') {
      sh 'mvn clean package -DskipTests'
    }
  }
  stage('Create Docker Image') {
    docker.withRegistry('sniffer.netex.ro:5000') {
        def newApp = docker.build("docker-jenkins-pipeline:${env.BUILD_NUMBER}")
	newApp.push()
    }
  }

//  checkpoint 'Build image'

}
