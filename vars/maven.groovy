def call(String miparam){

    println "Valor Ingresado: " + miparam
    
    def list = ['compile_code','test_code','jar_code', 'sonarQube', 'uploadNexus']

    // `it` is the current element, while `i` is the index

    
    String[] misStage;
    str = miparam.split(';');
    if (miparam == ";") {
        println "El valor ingresado es vacio, se procesan todos los stages: " 
        list.eachWithIndex { it, i -> 
            println "Stage a procesar: " + str[i] + ' it: ' + it    
                Stages."${it}"()
        }
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + ' it: ' + it
                Stages."${it}"()
        }
    }
}

return this;
