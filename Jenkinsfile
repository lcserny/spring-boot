#!/usr/bin/env groovy
node {

  checkout scm
  env.PATH = "${tool 'Maven'}/bin:${env.PATH}"
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