def call(){

def ci = ['buildAndTest','sonar','runJar','rest','nexusCI']
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

return this;
