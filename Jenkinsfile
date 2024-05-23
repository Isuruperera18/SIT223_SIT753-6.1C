pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '6d88bd66-93d8-4842-a73e-75bc2a6a0e4d', url: 'https://github.com/Isuruperera18/SIT223_SIT753-6.1C.git']])
                    echo 'Stage 1: Build'
                    echo 'Task: Build the code using a build automation tool to compile and package the code.'
                    echo 'Tool: Maven (for Java projects)'
                    sh 'mvn clean package'
                }
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                script {
                    echo 'Stage 2: Unit and Integration Tests'
                    echo 'Task: Run unit tests to ensure the code functions as expected and run integration tests to ensure different components of the application work together as expected.'
                    echo 'Tool: JUnit (for unit tests), TestNG (for integration tests)'
                    sh 'mvn test'
                }
            }
            post {
                success {
                    emailext(
                        to: 'mytestaccforyou@gmail.com',
                        subject: "Unit and Integration Tests Successful - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The unit and integration tests stage was successful.",
                        attachLog: true
                    )
                }
                failure {
                    emailext(
                        to: 'mytestaccforyou@gmail.com',
                        subject: "Unit and Integration Tests Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The unit and integration tests stage failed. Please check the logs.",
                        attachLog: true
                    )
                }
            }
        }
        stage('Code Analysis') {
            steps {
                script {
                    echo 'Stage 3: Code Analysis'
                    echo 'Task: Integrate a code analysis tool to analyze the code and ensure it meets industry standards.'
                    echo 'Tool: SonarQube'
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Security Scan') {
            steps {
                script {
                    echo 'Stage 4: Security Scan'
                    echo 'Task: Perform a security scan on the code using a tool to identify any vulnerabilities.'
                    echo 'Tool: OWASP Dependency-Check'
                }
            }
            post {
                success {
                    emailext(
                        to: 'mytestaccforyou@gmail.com',
                        subject: "Security Scan Successful - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The security scan stage was successful.",
                        attachLog: true
                    )
                }
                failure {
                    emailext(
                        to: 'mytestaccforyou@gmail.com',
                        subject: "Security Scan Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The security scan stage failed. Please check the logs.",
                        attachLog: true
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                script {
                    echo 'Stage 5: Deploy to Staging'
                    echo 'Task: Deploy the application to a staging server.'
                    echo 'Tool: AWS CLI (to deploy to AWS EC2 instance)'
                }
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                script {
                    echo 'Stage 6: Integration Tests on Staging'
                    echo 'Task: Run integration tests on the staging environment to ensure the application functions as expected in a production-like environment.'
                    echo 'Tool: Selenium'
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                script {
                    echo 'Stage 7: Deploy to Production'
                    echo 'Task: Deploy the application to a production server.'
                    echo 'Tool: AWS CLI (to deploy to AWS EC2 instance)'
                }
            }
        }
    }

    post {
        failure {
            emailext(
                to: 'mytestaccforyou@gmail.com',
                subject: "Jenkins Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) Failed",
                body: "Something went wrong with ${env.JOB_NAME} #${env.BUILD_NUMBER}. Please check the logs.",
                attachLog: true
            )
        }
        success {
            emailext(
                to: 'mytestaccforyou@gmail.com',
                subject: "Jenkins Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) Succeeded",
                body: "The build and deployment of ${env.JOB_NAME} #${env.BUILD_NUMBER} was successful.",
                attachLog: true
            )
        }
    }
}
