// 'buildAndTest','sonar', 'runJar', 'rest', 'nexusCI' 

def buildAndTest(){ 
    stage('buildAndTest') 
	{
        figlet env.STAGE_NAME
        env.TAREA = env.STAGE_NAME
        bat "gradlew clean build"
    }
}

def sonar(){ 
    stage('sonar') 
    {
        script 
        {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }
        
            // Coresponde a lo que se configuro en tool conffiguration
        def scannerHome = tool 'Sonar-Scanner';
            
        withSonarQubeEnv('Sonar-Server') 
        { 
            bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
        }
    }
}

def runJar(){
    stage('runJar')
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        "start gradlew bootRun &"
    }
}

def rest(){ 
    stage('rest') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
    }
}

def nexus(){ 
        stage('nexus') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
    }
}


return this;