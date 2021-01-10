def call(){

    def list = ['buildAndTest','sonar','runJar','rest','nexusCI']
    def cdstag = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    
    
    // `it` is the current element, while `i` is the inde   

    def matcher_dev = BRANCH_NAME =~ /develop/
    def matcher_fea = BRANCH_NAME =~ /feature/
    def matcher_rel = BRANCH_NAME =~ /release/
    
    
    if (matcher_dev || matcher_fea) {
        figlet "INTEGRACION CONTINUA"

         list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + i + ' it: ' + it    
               
        }
    }


    if (matcher_rel) {
        figlet 'ENTREGA CONTINUA'
        
        cdstag.eachWithIndex { it, i -> 
            println "Stage a procesar: " + it    
            cd_gradle."${it}"()
        }
    }

}

return this;
