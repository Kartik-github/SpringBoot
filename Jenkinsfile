// Jenkinsfile for deploying multiple microservices with Docker Compose
pipeline {
    agent any
    stages {
        stage('Checkout from GitHub') {
            steps {
                git(
                    credentialsId: 'github-id',
                    url: 'https://github.com/Kartik-github/SpringBoot.git',
                    branch: 'master'
                )
            }
        }
        stage('Build JARs') {
            steps {
                script {
                    // Define the projects to build.  Adjust these paths to match your repository structure.
                    def projects = [
                        'service-registry',
                        'api-gateway',
                        'config-server',
                        'movie-catalog-service',
                        'movie-streaming-service'
                        // Add other projects as needed
                    ]

                    // Build each project's JAR file.
                    for (def project in projects) {
                        echo "Building JAR for project: ${project}"
                        bat "cd ${project} && ./gradlew clean build" // Or "cd ${project} && mvn clean package"
                    }
                }
            }
        }
        stage('Build Images') {
            steps {
                script {
                    // Define the projects and their corresponding Dockerfile locations.
                    def dockerProjects = [
                        'service-registry':'service-registry/Dockerfile',
                        'api-gateway':'api-gateway/Dockerfile',
                        'config-server':'config-server/Dockerfile',
                        'movie-catalog-service':'movie-catalog-service/Dockerfile',
                        'movie-streaming-service':'movie-streaming-service/Dockerfile'
                        // Add other projects and their Dockerfile paths
                    ]

                    // Build a Docker image for each project.
                    for (def project in dockerProjects.keySet()) {
                        def dockerfile = dockerProjects[project]
                        echo "Building Docker image for project: ${project} from ${dockerfile}"

                        // Find the JAR file.
                        def jarPattern = "build/libs/*.jar"  //For Gradle
                        // def jarPattern = "target/*.jar"  //For Maven
                        def jarFile = findFiles(baseDir: project, glob: jarPattern)[0]?.name

                        if (!jarFile) {
                            error "JAR file not found for project: ${project}.  Check that the build was successful."
                        }
                        sh "docker build -t ${project.toLowerCase()}:${BUILD_NUMBER} --build-arg JAR_FILE=${jarFile} ${project}"
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the application using Docker Compose.
                //  You'll need a docker-compose.yml that defines services for all your microservices.
                bat 'docker-compose up -d --force-recreate'
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
