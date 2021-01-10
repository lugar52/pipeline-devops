def call(String miparam){

    println "Valor Ingresado: " + miparam
    
    def list = ['compile_code','test_code','jar_code','sonarQube','uploadNexus']
    miparam = 'compile_code;test_code;jar_code;sonarQube;uploadNexus'

    // `it` is the current element, while `i` is the index
        
    String[] misStage;
    str = miparam.split(';')
    if (miparam == ";") {
        println "Se procesa el arreglo: list" 
        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + list[i] + ' it: ' + it    
                stagesMaven."${it}"()
        }
    }
    else {
        println "Se procesa el arreglo: str" 
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + ' it: ' + it
                stagesMaven."${it}"()
        }
    }
}

return this;
