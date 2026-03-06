pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "prins05688/calculator"
    }

    stages {

        stage('Build Project') {
    steps {
        sh "${tool 'Maven'}/bin/mvn clean package -DskipTests"
    }
}

        
stage('Run Tests') {
    steps {
        sh "${tool 'Maven'}/bin/mvn test"
    }
}

        stage('Verify JAR') {
            steps {
                sh 'ls -lh target/'
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

}
