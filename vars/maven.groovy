def call(){

def ci = [ 'buildAndTest', 'sonar', 'runJar' , 'rest', 'nexusci' ]
def cd = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    if (BRANCH_NAME ==~ /develop/ || BRANCH_NAME ==~ /feature/  ) {                                                         
        figlet "INTEGRACION CONTINUA"
        ci.eachWithIndex { it, i -> 
            println "Stage a procesar: " + ci[i] + ' it: ' + it    
            cimaven."${it}"()
        }      
    }
    
    if (matcher_rel) {
        figlet 'ENTREGA CONTINUA'
        
        cd.eachWithIndex { it, i -> 
            println "Stage a procesar: " + cd[i] + ' it: ' + it    
            cdmaven."${it}"()
        }
    }

}

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

return this;
