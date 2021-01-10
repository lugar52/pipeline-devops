def call(){

    // def matcher_dev = BRANCH_NAME =~ /develop/
    // def matcher_fea = BRANCH_NAME =~ /feature/
    // def matcher_rel = BRANCH_NAME =~ /release/

    def ci = ['buildAndTest','sonar','runJar','rest','nexusCI', 'otro']
    def cd = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    if (BRANCH_NAME ==~ /develop/ || BRANCH_NAME ==~ /feature/  ) {                                                         
        figlet "INTEGRACION CONTINUA"
        ci.each {
            // println "Stage a procesar: " ${it} 
            stage(it){
                try {
                    "${it}"()
                }
                catch(Exception e) {
                    error "Error en el Stage: " 
                }
            }
        }      
    }
    
    if (matcher_rel) {
        figlet 'ENTREGA CONTINUA'
        
        cd.each {
            stage(it){
                try {
                    "${it}"()
                }
                catch(Exception e) {
                    error "Error en el Stage: ${it} ${e}" 
                }
            }
            
            println "Stage a procesar: " + cd[i] + ' it: ' + it    
            cdgradle."${it}"()
        }
    }

}

def buildAndTest(){ 
    figlet env.STAGE_NAME
    bat "gradlew clean build"
}

def nexusCI(){ 
    figlet env.STAGE_NAME
    
    nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
}


def sonar(){ 
    figlet env.STAGE_NAME
    // Coresponde a lo que se configuro en tool conffiguration
    def scannerHome = tool 'Sonar-Scanner';
        
    withSonarQubeEnv('Sonar-Server') 
    { 
        bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
    }
}

def runJar(){
    figlet env.STAGE_NAME
    env.TAREA =  env.STAGE_NAME
    "start gradlew bootRun &"
}

def rest(){ 
    figlet env.STAGE_NAME
    env.TAREA =  env.STAGE_NAME
    "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
}

def otro(){
    stage('otro'){
        println "Fin Integración continua"
    }
}

return this;
