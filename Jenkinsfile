pipeline {
    agent any
    
    stages {

        stage('PLANIFIER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
    
        stage('DEVELOPPER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
    
        
        stage('BUILDER') {
            steps {
                git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
        
        stage('TESTER') {
            parallel {
                stage('Tests Fonctionnels') {
                    steps {
                        script {
                        env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                            parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                        }
                        echo "${env.PLANIFIER_STATUS}"    
                    }
                }
                stage('Tests Performance') {
                    steps {
                        script {
                        env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                            parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                        }
                        echo "${env.PLANIFIER_STATUS}"    
                    }
                }
            }
        }
    
        stage('RELEASER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
    
        stage('DEPLOYER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
        
        stage('EXPLOITER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }
        
        stage('SURVEILLER') {
            steps {
                script {
                    env.PLANIFIER_STATUS = input message: 'Set action status', ok: 'Set',
                        parameters: [choice(name: 'TASK_STATUS', choices: 'Complete\nSkip', description: 'Select a status')]
                }
                echo "${env.PLANIFIER_STATUS}"    
            }
        }


    }
}
