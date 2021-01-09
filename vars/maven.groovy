def call(String miparam){

    println "Valor Ingresado: " + miparam
    
    def list = ['compile_code','test_code','jar_code', 'sonarQube', 'uploadNexus']

    // `it` is the current element, while `i` is the index

    
    String[] misStage;
    str = miparam.split(';');
    if (miparam == ";") {
        println "El valor ingresado es vacio, se procesan todos los stages: " 
        list.eachWithIndex { it, i -> 
                
                var1 = "stgradle."
                var2 = it
                var3 = "()"
                varStage = var2 
                println "stmaven.${var2}${var3}"
                // stgradle.compile_code()
                "${var1}${var2}"()
        }
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + ' it: ' + it
            switch(str[i]) {            
                //There is case statement defined for 4 cases 
                // Each case statement section has a break condition to exit the loop 
                    
                case list[0]: 
                    
                    stgradle.build()
                    break; 
                case list[1]: 
                    
                    stgradle.build()
                    break; 
                case list[2]: 
                    
                    stgradle.sonar()
                    break; 
                case list[3]: 
                    
                    stgradle.running()
                    break; 
                case list[4]: 
                    
                    stgradle.rest()
                    break; 
                case list[5]: 
                    
                    stgradle.nexus()
                    break; 
                default: 
                    println("The value is unknown"); 
                    break; 
            }
        }
        
    }

}

return this;
