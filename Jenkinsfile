pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Godzer2029/TestAutomationProject.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Тесты прошли успешно! Можно развернуть проект.'
        }
        failure {
            echo 'Тесты завершились с ошибкой! Развертывание проекта отменено.'
        }
    }
}
