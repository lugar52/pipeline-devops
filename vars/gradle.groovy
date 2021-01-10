def call(){

    // def matcher_dev = BRANCH_NAME =~ /develop/
    // def matcher_fea = BRANCH_NAME =~ /feature/
    // def matcher_rel = BRANCH_NAME =~ /release/

    def list = ['buildAndTest','sonar','runJar','rest','nexusCI']
    // def cdstag = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    if (BRANCH_NAME ==~ /develop/ || BRANCH_NAME ==~ /feature/  ) {                                                         
        figlet "INTEGRACION CONTINUA"
        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + list[i] + ' it: ' + it    
        // stagesMaven."${it}"()
        }

        
    }
    else {
        throw new RuntimeException("Oops, text not found!")
    }
   
    // if (m.find(0)) {                                                         
    //     
    //     
    //     
    // }
    
 //   if (matcher_dev || matcher_fea) {


   // }


    // if (matcher_rel) {
    //     figlet 'ENTREGA CONTINUA'
    //     
    //     cdstag.eachWithIndex { it, i -> 
    //         println "Stage a procesar: " + it    
    //         cd_gradle."${it}"()
    //     }
    // }

}

return this;
