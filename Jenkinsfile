pipeline {
       agent any
    stages {
        stage('Build') {
            steps {
                sh 'sudo apt install default-jdk'
                sh 'sudo apt install maven'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
