def call(){
  
  pipeline {
    agent any

    parameters { choice(name: 'herramientas', choices: ['gradle', 'maven'], description: '') }
    
    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {
                    println 'Herramientas de ejecucion seleccionadas: ' + params.herramientas
                    //env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.herramientas}] [Ejecucion exitosa]'"

                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {

        success {
            script {
                env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.herramientas}] Ejecucion exitosa'"
            }
            println "Este es el mensaje " + env.SUMMARY
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
        }

        failure {
                    
            script {
                env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.herramientas}] 'Ejecución fallida en stage' [${env.TAREA}]'"
            }

            println env.TAREA
            println "Este es el mensaje " + env.SUMMARY
            
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
        }
    }
  }
}

return this;