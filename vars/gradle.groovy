def call(){

    
    
    // `it` is the current element, while `i` is the inde   

    def matcher_dev = BRANCH_NAME =~ /develop/
    def matcher_fea = BRANCH_NAME =~ /feature/
    def matcher_rel = BRANCH_NAME =~ /release/
    
    
    if (matcher_dev || matcher_fea) {
        figlet 'INTEGRACION CONTINUA'
        def list = ['buildAndTest','sonar', 'runJar', 'rest', 'nexusCI' ]

        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + it    
            ci_Gradle."${it}"()
        }
    }


    if (matcher_rel) {
        figlet 'ENTREGA CONTINUA'
        
        def list = ['downloadNexus','runDownloadedJar','rest','nexusCD']

        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + it    
            cd_gradle."${it}"()
        }
    }

}

return this;
