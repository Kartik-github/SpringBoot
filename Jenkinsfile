// Jenkinsfile for deploying multiple microservices with Docker Compose (Local)

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from a local Git repository.
                //  This assumes that the repository is on the same machine as the Jenkins agent,
                //  and that you've already cloned it.  You might not need this step
                //  if your Jenkinsfile is already in the repo and Jenkins is set to execute
                //  in that directory.  If that is the case, you can remove this stage.
                git(
                    credentialsId:'github-id'
                    url: 'https://github.com/Kartik-github/SpringBoot.git',  // Replace with the actual path to your local Git repo
                    branch: 'main',
                    //  credentialsId: 'your-git-credentials-id'  //Remove this line
                )
            }
        }
        stage('Build Images') {
            steps {
                // Build the Docker images for all microservices defined in your docker-compose.yml.
                // This assumes your Dockerfiles are in the correct directories.
                sh 'docker-compose build'
            }
        }
        stage('Test') {
            steps {
                // Run tests.  Adapt to your testing strategy.
                sh 'docker-compose run --rm app ./gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the application using Docker Compose.
                // This assumes that your docker-compose.yml is configured to build images
                // locally. We use docker-compose up -d to start the services.
                sh 'docker-compose up -d --force-recreate'
            }
        }
        stage('Post-Deployment Verification') {
            steps {
                //  Add verification steps here.
                sleep 5
                sh 'curl http://your-service1-host:your-service1-port/actuator/health'
                sh 'curl http://your-service2-host:your-service2-port/actuator/health'
            }
        }
    }
    post {
        always {
            echo 'Post-execution: Cleaning up...'
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
