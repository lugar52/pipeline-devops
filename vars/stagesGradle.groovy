def build(){ 
    stage('Build & test') 
	{
        figlet env.STAGE_NAME
        env.TAREA = env.STAGE_NAME
        bat "gradlew clean build"
    }
}

def sonar()
{
	stage('sonar') 
	{
            //env.FAILED_STAGE = StepEnum.SONAR
            withSonarQubeEnv(installationName: 'Sonar-Server') 
		{
                	bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
            	}
		
        }
        stage("Quality gate") 
	{
            //env.FAILED_STAGE = "$StepEnum.SONAR Quality gate"
            waitForQualityGate abortPipeline: true
        }
}

stage("Quality gate") {
            env.FAILED_STAGE = "$StepEnum.SONAR Quality gate"
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

def nexus(){ 
        stage('Nexus') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
    }
}


def rest(){ 
    stage('Rest') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
    }
}


def running(){
    stage('Run')
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        "start gradlew bootRun &"
    }
}

def otro() {

}
	
def qualityGateValidation(qg) {
     if(qg.status != true ) {
	emailext body: "La Cobertura del escaneo es menor a 70%", subject: "Error Sonar Scan,Quality Gate", to: "${EMAIL_ADDRESS}"
	 	return true
	  }
		 emailext body: "La Cobertura del escaneo es mas del 70% - SUCCESS", subject: "Info - Ejecucion pipeline", to: "${EMAIL_ADDRESS}"
	     return false
}


return this;
