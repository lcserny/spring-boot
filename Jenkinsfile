#!/usr/bin/env groovy
node {

  checkout scm
  env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
  stage('Package') {

    withEnv(['M2_HOME = /root/.m2/repository']) {  
      sh 'mvn clean package'
      }

  }
  stage('Create Docker Image') {

    container_name = docker-jenkins-pipeline
       
    def new_container = docker.build("${container_name}:${env.BUILD_TAG}")

	

  }
    

  checkpoint 'The Image has been build'


  stage('Test Running Docker Image') {

	
    docker.image(new_container).withRun("--name = ${container_name} -p 8081:8080 " ) { c ->

    waitUntil {
		
      sleep 10 SECONDS
      sh 'docker  --format="{{ .State.Running }}" ${container_name} > /tmp/result_value' 
      result_value = readFile '/tmp/result_value'
    
      echo "Docker container running status is (${result_value})"

      sh 'rm -rf /tmp/result_value'

      return ${result_value}
		
      }
    }
  }
    
  stage('Push Docker Image') {

    docker.withRegistry('http://sniffer.netex.ro:5000') {
	new_container.push()
    }
  }
}


