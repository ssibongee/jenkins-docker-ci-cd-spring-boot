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

        stage('test') {
            steps {
                script {
                    sh 'mvn surefire:test'
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('deploy') {
            steps {
                script {
                    sh "ssh -p ${DEPLOY_SERVER_PORT} ${DEPLOY_SERVER_IP} -T sh < /var/jenkins/deploy.sh"       
                }
            }
        }

    }
}
