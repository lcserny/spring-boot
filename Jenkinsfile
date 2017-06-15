#!/usr/bin/env groovy
node {

  checkout scm
  env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
  stage('Package') {
      sh 'mvn clean package'
    
  }
  stage('Create Docker Image') {
    docker.withRegistry('sniffer.netex.ro:5000') {
        def newApp = docker.build("docker-jenkins-pipeline:${env.BUILD_NUMBER}")
	newApp.push()
    }
  }

//  checkpoint 'Build image'

}
