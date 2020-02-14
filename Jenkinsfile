pipeline {
         agent any
             stages {
	          
                 stage('Source') {
                    steps {
                       checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url:'https://komalsahu@dev.azure.com/komalsahu/SkillAssure%20Discoveri/_git/heartihealth-services']]])
	            }        
                 }
                  stage('ServiceBuild') {
                    tools{
                      jdk 'jdk8'
                      maven 'Maven'
                    }
                            steps { 
                              script{
                                bat label: '', script: 'mvn install'
				                bat label: '', script: 'mvn clean package'
                               }
                           }
		  }
		     stage('Archiving Artifacts') { 
                         steps{ 
                             archiveArtifacts 'discoveri-heartihealth-webapp/target/*.jar' 
                         } 
                 } 
                   stage('CreateService'){
		       steps{
                           script{
                              bat "CreateService.bat"
		           }
                       }
		   }
	}
}
