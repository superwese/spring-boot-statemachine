@Library(['deployment-tracking']) _
pipeline {
        agent {
            docker 'docker.cloud-mobile.testo250.net/ci-docker-sam-cli-java11:1.7.0'
        }

        options {
            buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '30'))
            timeout(time: 12, unit: 'HOURS')
            timestamps()
        }

        environment {
            SAM_CLI_TELEMETRY = 0
        }

        stages {


                stage('Check templates') {
                        steps {
                            dir('statemachine') {
                                withAWS(credentials: 'savr-pipeline', region: 'eu-central-1') {
                                wrap([$class: 'AnsiColorBuildWrapper']) {
                                    sh 'sam validate'
                                }
                            }
                        }
                    }
                }

                stage('Compile & Test') {
                    steps {
                        wrap([$class: 'AnsiColorBuildWrapper']) {
                            sh "sam build"
                        }
                    }
                }

                stage('Deploy Integration') {
                    when {
                        branch 'master'
                    }
                    steps {
                        withAWS(credentials: 'savr-pipeline', region: 'eu-central-1') {
                            wrap([$class: 'AnsiColorBuildWrapper']) {
                                sh "sam --version"
                                sh "sam deploy --no-progressbar --config-env integration"
                            }
                        }
                    }
                }
/*
            stage('Proceed') {
                when {
                    branch 'master'
                }
                steps {
                    input message: "Proceed on Production?"
                }

            }

            stage("Deploy Production") {
                when {
                    branch 'master'
                }

                stages {
                    stage('qs') {
                        steps {
                            withAWS(credentials: 'savr-pipeline', region: 'eu-central-1') {
                                wrap([$class: 'AnsiColorBuildWrapper']) {
                                    sh "sam deploy --no-progressbar --config-env qs"
                                }
                            }
                        }
                    }

                    stage('eu-central-1') {
                        steps {
                            withAWS(credentials: 'savr-pipeline', region: 'eu-central-1') {
                                wrap([$class: 'AnsiColorBuildWrapper']) {
                                    sh "sam deploy --no-progressbar --config-env prod-eu"
                                }
                            }
                        }
                    }

                    stage('us-west-2') {
                        steps {
                            withAWS(credentials: 'savr-pipeline', region: 'us-west-2') {
                                wrap([$class: 'AnsiColorBuildWrapper']) {
                                    sh "sam deploy --no-progressbar --config-env prod-americas"
                                }
                            }
                        }
                    }
                    stage('ap-southeast-1') {
                        steps {
                            withAWS(credentials: 'savr-pipeline', region: 'ap-southeast-1') {
                                wrap([$class: 'AnsiColorBuildWrapper']) {
                                    sh "sam deploy --no-progressbar --config-env prod-apac"
                                }
                            }
                        }
                    }
                }
            }

 */

        }

}
