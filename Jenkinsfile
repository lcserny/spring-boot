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

    docker.withRegistry('http://sniffer.netex.ro:5000') {

	container_name = "docker-jenkins-pipeline"    

	def new_container = docker.build("${container_name}:${env.BUILD_TAG}")
    
	stage('Test Running Docker Image') {

	docker.image("${container_name}:${env.BUILD_TAG}").withRun(" -p 8081:8080 --name ${container_name}" ) { c ->

        waitUntil {
    		
    	  sh "docker inspect --format='{{ .State.Running }}' ${container_name} | tr -d '\n' > /tmp/result_value"
    	  def result_value = readFile '/tmp/result_value'
    
          echo "Docker container running status is ${result_value}"

	  if ("${result_value}" == 'true')
  	   {
          	echo "Container ${container_name} is running"
		sh 'rm -rf /tmp/result_value'
	        return true
  	   }
  	   else
  	   {
          	echo "Container ${container_name} is NOT running"
          	return false
  	    }
	}

      }
    }
	stage('Push Docker Image') {
    	    new_container.push()
    }
	stage('Remove Docker Image') {
	
	    try {
	        sh "docker rmi ${container_name}:${env.BUILD_TAG}"
		echo "Docker image ${container_name}:${env.BUILD_TAG} has been removed"
	    } cache ( e ){
		echo "Unable to remove image ${container_name}:${env.BUILD_TAG}"
		throw e
	    } 
	}	  
   }
 }
}


