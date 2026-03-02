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

        stage('Deploy with Ansible') {
            steps {
                sh '''
                ansible-playbook ansible/deploy.yml \
                -i ansible/inventory.ini
                '''
            }
        }
    }

    post {
        success {
            emailext(
                subject: "SUCCESS: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """Build Successful
Project: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}
Build URL: ${BUILD_URL}
""",
                to: "prins07860@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "FAILURE: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """Build Failed
Project: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}
Check Console Output: ${BUILD_URL}console
""",
                to: "prins07860@gmail.com"
            )
        }
    }
}
