def call(){ 
        stage('Run') 
	{
        env.TAREA =  env.STAGE_NAME
        "start gradlew bootRun &"            
    }
}