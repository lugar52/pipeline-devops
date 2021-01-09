package stages.

def call(){ 
    stage('Build & test') 
	{
        figlet env.STAGE_NAME
        env.TAREA = env.STAGE_NAME
        bat "gradlew clean build"
    }
}

return this;

