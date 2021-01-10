//'buildAndTest','sonar','runJar','rest','nexusCI'

def buildAndTest(){
    stage('buildAndTest'){
        script {
            figlet env.STAGE_NAME
            env.TAREA = env.STAGE_NAME
        }
        
        bat './mvnw.cmd clean compile -e'
        bat './mvnw.cmd clean test -e'
    }
}

