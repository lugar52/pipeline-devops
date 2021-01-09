/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/
import gra.*

def call(String miparam){

    println "Valor Ingresado: " + miparam
    def list = ['build','test','sonar', 'run', 'rest', 'nexus' ]

    // `it` is the current element, while `i` is the index

    
    String[] misStage;
    str = miparam.split(';');
    if (miparam == ";") {
        println "El valor ingresado es vacio, se procesan todos los stages: " 
        stgradle.build("a")

        sonar.call()

        run.call()

        rest.call()

        nexus.call()
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i] + 'it: ' + it
            switch(str[i]) {            
                //There is case statement defined for 4 cases 
                // Each case statement section has a break condition to exit the loop 
                    
                case list[0]: 
                    
                    build.call()
                    break; 
                case list[1]: 
                    
                    build.call()
                    break; 
                case list[2]: 
                    
                    sonar.call()
                    break; 
                case list[3]: 
                    
                    run.call()
                    break; 
                case list[4]: 
                    
                    rest.call()
                    break; 
                case list[5]: 
                    
                    nexus.call()
                    break; 
                default: 
                    println("The value is unknown"); 
                    break; 
            }
        }
        
    }

}

return this;
