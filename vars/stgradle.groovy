def build(){ 
    stage('Build & test') 
	{
        figlet env.STAGE_NAME
        env.TAREA = env.STAGE_NAME
        bat "gradlew clean build"
    }
}

def sonar(){ 
    stage('SonarQube analysis') 
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

// def run(){
//     stage('Run')
// 	{
//         figlet env.STAGE_NAME
//         env.TAREA =  env.STAGE_NAME
//         "start gradlew bootRun &"
//     }
// }
// 
// return this;