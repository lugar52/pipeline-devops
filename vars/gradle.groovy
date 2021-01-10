def call(){

    
    def list = ['build','test','sonar', 'run', 'rest', 'nexus' ]
    // `it` is the current element, while `i` is the inde   

    def matcher_dev = BRANCH_NAME =~ /develop/
    def matcher_fea = BRANCH_NAME =~ /feature/
    if (matcher_dev || matcher_fea) {
        figlet BRANCH_NAME
    }
    println matcher.size()
    


    
    
    if (BRANCH_NAME == "develop" || BRANCH_NAME == "feature" ) {
        println "Se procesa el arreglo: list" 
        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + list[i] + ' it: ' + it    
               // stagesGradle."${it}"()
        }
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + ' it: ' + it
        }
        
    }

}

return this;
