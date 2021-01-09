def call(){ 
    stage('Rest') 
	{
        env.TAREA =  env.STAGE_NAME
        "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
    }
}

