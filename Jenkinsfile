pipeline {
    agent any

    options {
        timeout(time: 1, unit: 'HOURS')
    }
    environment {
        clusterName = 'chc-microservice'
        serviceName = 'rds-poc'
        repositoryName = 'rds-poc'
        regionName = 'us-west-2'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/CletusLee/rds-poc'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.5.3-jdk-8'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            agent {
                docker {
                    image 'maven:3.5.3-jdk-8'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            agent {
                docker {
                    image 'maven:3.5.3-jdk-8'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }
        stage('Publish Reports') {
            steps {
               publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'Code Coverage', reportTitles: ''])
               junit 'target/surefire-reports/TEST-*.xml'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh("eval \$(aws ecr get-login --no-include-email --region ${regionName} | sed 's|https://||')")
                    docker.withRegistry('https://988532124766.dkr.ecr.us-west-2.amazonaws.com/${repositoryName}') {
                        customImage = docker.build("${repositoryName}:${env.BUILD_ID}")
                        customImage.push()
                        customImage.push('latest')
                    }
                }
            }
        }
        stage('QA Auto Test') {
            steps {
                sh "echo test"
            }
        }
        stage('Deploy to ECS cluster') {
            input {
                message "Deploy to ECS?"
            }
            steps {
                withAWS(region:'us-west-2', credentials:'aws') {
                    sh 'ecs-deploy -r us-west-2 -c ${clusterName} -n ${serviceName} -i 988532124766.dkr.ecr.us-west-2.amazonaws.com/${repositoryName}:${BUILD_ID} -t 6000'
                }
            }
        }
    }
}