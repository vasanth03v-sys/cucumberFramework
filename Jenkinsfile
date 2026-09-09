pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/vasanth03v-sys/cucumberFramework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}