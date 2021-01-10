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

def sonar(){
    stage('sonar') {
        figlet env.STAGE_NAME
    }
}

def runJar(){
        stage('runJar') {
        figlet env.STAGE_NAME
    }
}

def rest(){
        stage('rest') {
        figlet env.STAGE_NAME
    }
}

def nexusCI(){
        stage('nexusCI') {
        figlet env.STAGE_NAME
    }
}

def otro(){
    stage('otro') {
        figlet env.STAGE_NAME
    }
}
