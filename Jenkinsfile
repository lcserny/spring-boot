#!/usr/bin/env groovy
node {

  checkout scm
  env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
  stage('Package') {

    withEnv(['M2_HOME = /root/.m2/repository']) {  
      sh 'mvn -N io.takari:maven:wrapper'
      sh './mvnw clean package'
      }

  }

  stage('Create Docker Image') {

    
    withEnv(['docker_registry=sniffer.netex.ro:5000','container_name=docker-jenkins-pipeline']){ 
        docker.withRegistry("http://${docker_registry}") {


    	    def new_container = docker.build("${container_name}:${env.BUILD_TAG}")
    
	    stage('Testing Docker Image') {

	    docker.image("${container_name}:${env.BUILD_TAG}").withRun(" -p 8081:8080 --name ${container_name}" ) { c ->

            waitUntil {
    		
		sh "docker inspect --format='{{ .State.Running }}' ${container_name} | tr -d '\n' > /tmp/result_value"
    		def result_value = readFile '/tmp/result_value'
    
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
		
		} catch ( e ) {
		    echo "Unable to remove image ${container_name}:${env.BUILD_TAG}"
		    throw e

		} finally {
		    echo "Docker image ${container_name}:${env.BUILD_TAG} has been removed"

		}

		try {
	    	    sh "docker rmi ${docker_registry}/${container_name}:${env.BUILD_TAG}"
		
		} catch ( e ) {
		    echo "Unable to removei image ${docker_registry}/${container_name}:${env.BUILD_TAG}"
		    throw e

		} finally {
		    echo "Docker image ${docker_registry}/${container_name}:${env.BUILD_TAG} has been removed"

		}

	    }
	    }
	    
	    stage ('Deploying'){

		input message:'Prrove deployment to PRODUCTION?'
		docker.image('lachlanevenson/k8s-kubectl:v1.5.2').inside {
		    
		    withCredentials([[$class: "FileBinding", credentialsId: 'kubeconfig', variable: 'KUBE_CONFIG']]) {
		
			def kubectl = "kubectl  --kubeconfig=\$KUBE_CONFIG"
			sh "${kubectl} set image deployment/jenkins-pipeline jenkins-pipeline=${docker_registry}/${container_name}:${env.BUILD_TAG}"
			sh "${kubectl} rollout status deployment/jenkins-pipeline"
		    
		    }
		}
	    }
        }
   }
	stage ('Cleanup'){

        try {
	    deleteDir()
	} catch (e) {
	    echo "Unable to remove curent folder"
	    throw e
	} finally {
	    echo "Curent folder has been removed"
	}
 }
}


