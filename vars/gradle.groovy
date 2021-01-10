def call(){

    // def matcher_dev = BRANCH_NAME =~ /develop/
    // def matcher_fea = BRANCH_NAME =~ /feature/
    // def matcher_rel = BRANCH_NAME =~ /release/

    def ci = ['buildAndTest','sonar','runJar','rest','uploadNexus']
    def cd = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    if (BRANCH_NAME ==~ /develop/ || BRANCH_NAME ==~ /feature/  ) {                                                         
        figlet "INTEGRACION CONTINUA"
        ci.eachWithIndex { it, i -> 
            println "Stage a procesar: " + ci[i] + ' it: ' + it    
            cigradle."${it}"()
        }      
    }
    
    if (matcher_rel) {
        figlet 'ENTREGA CONTINUA'
        
        cd.eachWithIndex { it, i -> 
            println "Stage a procesar: " + cd[i] + ' it: ' + it    
            cdgradle."${it}"()
        }
    }

}

return this;
