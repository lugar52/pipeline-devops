def call(){ 
    stage('Build & test') 
	{
        env.TAREA = env.STAGE_NAME
        bat "gradlew clean build"
    }
}

