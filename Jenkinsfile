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
            subject: "Build ${currentBuild.currentResult}: ${JOB_NAME} #${BUILD_NUMBER}",
            body: """<h3>Build Result: ${currentBuild.currentResult}</h3>
<p>Project: ${JOB_NAME}</p>
<p>Build Number: ${BUILD_NUMBER}</p>
<p><a href="${BUILD_URL}console">Console Output</a></p>
""",
            mimeType: 'text/html'
        )
    }
}
}
