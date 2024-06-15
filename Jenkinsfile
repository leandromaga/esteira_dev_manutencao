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
                -Dsonar.login=sqp_04ea80553030c17d24234103563f31c67673a50a
            """
            }
        }
    }

        
    stage('Build') {
        steps {
            sh 'mvn clean package'
        }
    }

    stage('Deploy to Tomcat') {
            steps {
                script {
                    // Encontra o arquivo .war gerado no diretório target
                    def warFile = findFiles(glob: '**/target/*.war')[0]
                    // Escapa o símbolo de dólar para uso correto dentro do comando sh
                    def warPath = warFile.path.replace('$', '\$')
                    // Copia o arquivo .war para o container Tomcat
                    sh "docker cp ${warPath} \$(docker-compose ps -q tomcat):/usr/local/tomcat/webapps/enade.war"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}