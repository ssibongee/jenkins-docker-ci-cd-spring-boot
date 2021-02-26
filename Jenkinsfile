pipeline {
    agent any
    
    tools {
        maven 'maven'
    }

    stages {

        stage('clone') {

            steps {
                checkout scm;
            }
        }

        stage('build') {
            steps {
                sh "mvn clean package -DskipTests=true"
            }
        }

        stage('Unit Test') {
            steps {
                script {
                    sh 'mvn surefire:test'
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

    }
}
