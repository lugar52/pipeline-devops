def call(){ 
    stage('SonarQube analysis') {
        script {
            env.TAREA = env.STAGE_NAME
        }
        
                // Coresponde a lo que se configuro en tool conffiguration
            def scannerHome = tool 'Sonar-Scanner';
                
            withSonarQubeEnv('Sonar-Server') { 
                bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
            }
    }
}