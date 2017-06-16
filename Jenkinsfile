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
	try{
	    sh 'docker  --format="{{ .State.Running }}" ${container_name}'
	    echo "Container is running"
	    return true
	}
	cache(err){
	    echo "Container is not running! Failed ${err}"
	    return false
	}
		
      }
    }
  }
    
  stage('Push Docker Image') {

    docker.withRegistry('http://sniffer.netex.ro:5000') {
	new_container.push()
    }
  }
}


