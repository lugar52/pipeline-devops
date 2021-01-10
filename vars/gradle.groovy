def call(){

    // def matcher_dev = BRANCH_NAME =~ /develop/
    // def matcher_fea = BRANCH_NAME =~ /feature/
    // def matcher_rel = BRANCH_NAME =~ /release/

    def list = ['buildAndTest','sonar','runJar','rest','nexusCI']
    // def cdstag = ['downloadNexus','runDownloadedJar','rest','nexusCD']

    //  def list = ['compile_code','test_code','jar_code','sonarQube','uploadNexus']

    
    
    // `it` is the current element, while `i` is the inde   


    // def text = BRANCH_NAME
    // def m = text =~ /develop/  


    def text = "some text to match"
    
    if (BRANCH_NAME ==~ /develop/ ) {                                                         
        figlet "INTEGRACION CONTINUA"
        
    }
    else {
        throw new RuntimeException("Oops, text not found!")
    }
   
    // if (m.find(0)) {                                                         
    //     
    //     
    //     list.eachWithIndex { it, i -> 
    //         println "Stage a procesar: " + list[i] + ' it: ' + it    
    //     // stagesMaven."${it}"()
    //     }
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
