/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String miparam){

    println "Valor Ingresado: " + miparam
    def list = ['build','test','sonar', 'run', 'rest', 'nexus' ]

    // `it` is the current element, while `i` is the index

    
    String[] misStage;
    str = miparam.split(';');
    if (miparam == ";") {
        println "El valor ingresado es vacio, se procesan todos los stages: " 
        stgradle.build()

        stgradle.sonar.call()

        stgradle.run.call()

        stgradle.rest.call()

        stgradle.nexus.call()
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + 'it: ' + it
            switch(str[i]) {            
                //There is case statement defined for 4 cases 
                // Each case statement section has a break condition to exit the loop 
                    
                case list[0]: 
                    
                    stgradle.build.call()
                    break; 
                case list[1]: 
                    
                    stgradle.build.call()
                    break; 
                case list[2]: 
                    
                    stgradle.sonar.call()
                    break; 
                case list[3]: 
                    
                    stgradle.run.call()
                    break; 
                case list[4]: 
                    
                    stgradle.rest.call()
                    break; 
                case list[5]: 
                    
                    stgradle.nexus.call()
                    break; 
                default: 
                    println("The value is unknown"); 
                    break; 
            }
        }
        
    }

}

return this;
