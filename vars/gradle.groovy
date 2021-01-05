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
        build.call()
        sonar.call()
        run.call()
        rest.call()
        nexus.call()
    }
    else {
        str.eachWithIndex { it, i ->
            println "Stage a procesar: " + str[i]
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

    // stage('Build & test') 
	// {
    //     env.TAREA = env.STAGE_NAME
    //     bat "gradlew clean build"
    // }

//     stage('Sonar') 
// 	{
//         env.TAREA =  env.STAGE_NAME
// 		stage('SonarQube analysis') 
// 		{
//             env.TAREA =  env.STAGE_NAME
// 		    // Coresponde a lo que se configuro en tool conffiguration
// 			def scannerHome = tool 'Sonar-Scanner';
// 
// 			withSonarQubeEnv('Sonar-Server') 
// 			{ 
//                 bat start "${scannerHome}\\bin\\Sonar-Scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
// 			}
// 		}
//     }

    // stage('Run') 
	// {
    //     env.TAREA =  env.STAGE_NAME
    //     "start gradlew bootRun &"            
    // }

    // stage('Rest') 
	// {
    //     env.TAREA =  env.STAGE_NAME
    //     "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
    // }

    // stage('Nexus') 
	// {
    //     env.TAREA =  env.STAGE_NAME
    //     nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
    // }

}

return this;
