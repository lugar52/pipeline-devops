// 'downloadNexus','runDownloadedJar','rest','nexusCD'

def downloadNexus(){ 
    stage('downloadNexus') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        
        "curl -X GET -u admin:Vicente$$24 http://localhost:8081/repository/test-nexus/com/devopsusach2020/DevOpsUsach2020/0.0.1/DevOpsUsach2020-0.0.1.jar -O"
    }
}


def runDownloadedJar(){
    stage('runDownloadedJar')
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        "start gradlew bootRun &"
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

def nexus(){ 
        stage('nexus') 
	{
        figlet env.STAGE_NAME
        env.TAREA =  env.STAGE_NAME
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
    }
}