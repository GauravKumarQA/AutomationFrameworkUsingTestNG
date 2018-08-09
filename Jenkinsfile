 properties([parameters([choice(choices: 'hello1\nhello2', description: '', name: 'Env')]), pipelineTriggers([])])
node{
    stage('Pull from git hub'){
      git 'https://github.com/GauravKumarQA/AutomationFrameworkUsingTestNG'
    }
    stage('Maven test'){
        def mavenHome = tool name: 'M2_HOME', type: 'maven'
     
     
     stage ('Speak') {
            when {
                // Only say hello if a "greeting" is requested
                expression { params.Env == 'hello1' }
            }
            steps {
                bat "${mavenHome}/bin/mvn clean test -Denv=${params.Env}  -DbrowserName=chrome"
                bat "${mavenHome}/bin/mvn clean test -Denv=${params.Env}  -DbrowserName=chrome"
            }
    }
}
