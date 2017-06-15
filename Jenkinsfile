#!/usr/bin/env groovy
node {

  checkout scm
  env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
  stage('Package') {
      sh 'mvnw clean package'
    
  }
  stage('Create Docker Image') {
    docker.withRegistry('http://sniffer.netex.ro:5000') {
        def newApp = docker.build("docker-jenkins-pipeline:${env.BUILD_TAG}")
	newApp.push()
    }
  }

//  checkpoint 'Build image'

}
