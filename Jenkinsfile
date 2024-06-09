pipeline {
    agent any

    tools {
        maven "MAVEN"

    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/leandromaga/esteira_dev_manutencao.git']]])
            }
        }
        
    stage('Run Unit Tests') {
        steps {
            sh 'mvn test'
        }
    }

    stage('SonarQube Analysis') {
        steps {
            withSonarQubeEnv(installationName: 'manutencao') {
                sh """
                mvn clean verify sonar:sonar \
                -Dsonar.projectKey=manutencao \
                -Dsonar.host.url=http://sonarqube:9000 \
                -Dsonar.login=sqp_d12b2fda7a3e76215823adf937dcb479d03b8679
            """
            }
        }
    }

        
    stage('Build') {
        steps {
            sh 'mvn clean package'
        }
    }
}
}