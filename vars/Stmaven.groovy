def compile_code(){
    stage('compile_code'){
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }
        
        bat './mvnw.cmd clean compile -e'
    }
}

def test_code(){
    stage('test_code'){
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }

        bat './mvnw.cmd clean test -e'
    }
}

def jar_code(){
    stage('jar_code'){
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }

        bat './mvnw.cmd clean package -e'
    }
}

def sonarQube(){
    stage('sonarQube') {
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }

        withSonarQubeEnv(installationName: 'Sonar-Server') 
        { 
            bat './mvnw.cmd org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
        }
    }
}

def uploadNexus(){
    stage('uploadNexus'){
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }

        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-maven\\build\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
    }   
}



return this;
