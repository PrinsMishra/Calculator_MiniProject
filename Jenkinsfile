pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "prins05688/calculator"
    }

    stages {

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
    }

 post {
    always {
        emailext(
            subject: "Build ${currentBuild.currentResult}: #${BUILD_NUMBER}",
            body: """Build Result: ${currentBuild.currentResult}

Project: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}
Check Jenkins for details.
""",
            to: "prins07860@gmail.com",
            mimeType: 'text/html'
        )
    }
}
}
