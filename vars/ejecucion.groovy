def call(){
  
  pipeline {
    agent any

    parameters { choice(name: 'herramientas', choices: ['gradle', 'maven'], description: '') }
    // string(name: 'stage', defaultValue: '', descripcion: 'taller devops')

    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {
                  println 'Herramientas de ejecucion seleccionadas: ' + params.herramientas

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
