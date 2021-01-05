def call(){ 
    stage('Sonar') 
	{
        env.TAREA =  env.STAGE_NAME
		stage('SonarQube analysis') 
		{
            env.TAREA =  env.STAGE_NAME
		    
			def scannerHome = tool 'Sonar-Scanner';

			withSonarQubeEnv('Sonar-Server') 
			{ 
                bat start "${scannerHome}\\bin\\Sonar-Scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
			}
		}
    }
}