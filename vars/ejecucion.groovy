def call(){
  
  pipeline {
    agent any

    parameters { 
      choice(name: 'buildtool', choices: ['gradle', 'maven'], description: '')
      string(name: 'stage', defaultValue: '', description: 'taller devops') 
      }
     

    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {
                  figlet "set"
                  bat 'set'
                  println 'Herramientas de ejecucion seleccionadas: ' + params.buildtool
                  //println 'Valor param.stage: ' + params.stage
                  

                    if (params.buildtool == 'gradle') {
                      gradle.call()
                    } else {
                      maven.call()
                    }

                  

                }
            }
        }
    }
    post {

        success {
            script {
                env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.buildtool}] Ejecucion exitosa'"
            }
            println "Este es el mensaje " + env.SUMMARY
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
        }

        failure {
                    
            script {
                env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.buildtool}] 'Ejecución fallida en stage' [${env.TAREA}]'"
            }

            println env.TAREA
            println "Este es el mensaje " + env.SUMMARY
            
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
        }
    }
  }
}

return this;
