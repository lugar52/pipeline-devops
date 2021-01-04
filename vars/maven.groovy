/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){

        stage('compile_code'){
                script {
                        env.TAREA = env.STAGE_NAME
                }
                
                bat './mvnw.cmd clean compile -e'
        }
        stage('test_code'){
                script {
                        env.TAREA = env.STAGE_NAME
                }

                bat './mvnw.cmd clean test -e'
        }
        stage('jar_code'){
                script {
                        env.TAREA = env.STAGE_NAME
                }

                bat './mvnw.cmd clean package -e'
        }
        stage('sonarQube') {
                script {
                        env.TAREA = env.STAGE_NAME
                }

                withSonarQubeEnv(installationName: 'Sonar') 
                { // You can override the credential to be used
                bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                }
        }
        stage('uploadNexus'){
                script {
                        env.TAREA = env.STAGE_NAME
                }

                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-maven\\ejemplo-maven\\build\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
        }
}

return this;
